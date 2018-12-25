package com.shgbit.hswbservice.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shgbit.hswbservice.app.entity.Spdsrsj;
import com.shgbit.hswbservice.app.entity.SpdsrsjList;
import com.shgbit.hswbservice.app.mapper.SpdsrsjMapper;
import com.shgbit.hswbservice.app.service.ISpdsrsjService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shgbit.hswbservice.utils.XmlReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spdsr.SpDsrServices;
import spdsr.SpDsrServicesImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuanrxupup
 * @since 2018-12-19
 */
@Service
@Slf4j
@Transactional
public class SpdsrsjServiceImpl extends ServiceImpl<SpdsrsjMapper, Spdsrsj> implements ISpdsrsjService {
    @Autowired
    SpdsrsjMapper spdsrsjMapper;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int deleteAndInsert() {
        int i=0;
        deletSpdsr();
        insetSpdsr();
        return i;
    }

    @Override
    public int insetSpdsr() {
        //创建视图
        SpDsrServicesImpl spDsrServicesImpl=new SpDsrServicesImpl();
        //获取服务实现类
        SpDsrServices spDsrServices=spDsrServicesImpl.getPort(SpDsrServices.class);
        //获取年份xml
        String s=spDsrServices.getAllNDH();
//        String s="";
        log.info("审判当事人获取年份xml:===="+s);
        XmlReader xmlReader=new XmlReader();
        //返回年份列表
        List<Integer> list=xmlReader.getNDH(s);
        for (Integer i:list
                ) {
            log.info("审判当事人年份：========"+i.toString());
            //返回案件数据xmlStr
            String xmlStr=spDsrServices.getDataByNDH(i);
//            Document doc =null;
//            //读取解析xml
//            SAXReader reader=new SAXReader();
//            try {
//                doc=reader.read("file:///E:/myproject/xml/NDH.xml");
//            } catch (DocumentException e) {
//                e.printStackTrace();
//            }
//            String xmlStr=doc.asXML();

//            Spajxx spajxx= XmlUtils.parseFromXml(Spajxx.class,xmlStr);
            XStream xstream=new XStream(new DomDriver());
            XStream.setupDefaultSecurity(xstream);
            xstream.allowTypes(new Class[]{SpdsrsjList.class, Spdsrsj.class});
            //设置安全性
            xstream.autodetectAnnotations(true);
            xstream.processAnnotations(SpdsrsjList.class);

            //获取实体类列表
            SpdsrsjList spdsrsjList=(SpdsrsjList)xstream.fromXML(xmlStr);
            if(spdsrsjList!=null){
                log.info(i+"年获取到"+spdsrsjList.getSpdsrsjList().size()+"条数据！！！！！！！！！！！！！！");
                for (Spdsrsj spdsrsj:spdsrsjList.getSpdsrsjList()
                     ) {
                    spdsrsj.setId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
                    LocalDateTime time = LocalDateTime.now();
                    spdsrsj.setUpdateTime(time);
                    int j=0;
                    j=spdsrsjMapper.insert(spdsrsj);
                }
            }
        }
        log.info("接口调用完毕并插库成功");
        return 0;
    }

    @Override
    public int deletSpdsr() {
        int i=0;
        spdsrsjMapper.insertSpdsrsjLog();
        log.info("成功删除向spdsrsjLog表插入了数据！！！！！！！！！！");
        QueryWrapper<Spdsrsj>queryWrapper=new QueryWrapper<Spdsrsj>().eq("1","1");
        List<Spdsrsj>list=spdsrsjMapper.selectList(queryWrapper);
        for (Spdsrsj spa:list
             ) {
            String id=spa.getId();
            i=spdsrsjMapper.deleteById(id);
        }
        log.info("成功删除"+list.size()+"行数据！！！！！！！！！！");
        return i;
    }
}
