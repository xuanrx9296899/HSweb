package com.shgbit.hswbservice.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shgbit.hswbservice.app.entity.Spajxx;
import com.shgbit.hswbservice.app.entity.SpajxxList;
import com.shgbit.hswbservice.app.mapper.SpajxxMapper;
import com.shgbit.hswbservice.app.service.ISpajxxService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shgbit.hswbservice.utils.XmlReader;
import com.shgbit.hswbservice.utils.XmlUtils;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spajxx.SpAjServices;
import spajxx.SpAjServicesImpl;
import spdsr.SpDsrServices;
import spdsr.SpDsrServicesImpl;

import java.sql.Wrapper;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
public class SpajxxServiceImpl extends ServiceImpl<SpajxxMapper, Spajxx> implements ISpajxxService {
    @Autowired
    SpajxxMapper spajxxMapper;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int deleteAndInsert() {
        int i=0;
        deleteSpajxx();
        i=insetSpajxx();
        return  i;
    }

    @Override
    public int insetSpajxx() {
        //创建视图
        SpAjServicesImpl spAjServices=new SpAjServicesImpl();
        //获取服务实现类
        SpAjServices spAjServices1=spAjServices.getPort(SpAjServices.class);
        //获取年份xml
        String s=spAjServices1.getAllNDH();
//        String s="";
        log.info("审判案件信息获取年份xml:===="+s);
        XmlReader xmlReader=new XmlReader();

        //返回年份列表
        List<Integer> list=xmlReader.getNDH(s);
        System.out.println(list.size());
        for (Integer i:list
                ) {
            log.info("审判案件信息年份：========"+i.toString());
            //返回案件数据xmlStr
            String xmlStr=spAjServices1.getDataByNDH(i);
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
            xstream.allowTypes(new Class[]{SpajxxList.class, Spajxx.class});
            //设置安全性
            xstream.autodetectAnnotations(true);
            xstream.processAnnotations(SpajxxList.class);
            //获取实体类列表
            SpajxxList spajxxList= (SpajxxList) xstream.fromXML(xmlStr);
//            System.out.println(spajxxList.getSpajxxList().size());
            if(spajxxList!=null) {
                log.info(i+"年获取到"+spajxxList.getSpajxxList().size()+"条数据！！！！！！！！！！！！！！");
                for (Spajxx spajxx : spajxxList.getSpajxxList()
                        ) {
                    spajxx.setId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
                    LocalDateTime time = LocalDateTime.now();
                    spajxx.setUpdatetime(time);
                    int j=0;

                    j = spajxxMapper.insert(spajxx);
                }
            }

        }
        log.info("接口调用完毕并插库成功");
        return 0;
    }

   @Override
   public  int deleteSpajxx(){
        int i=0;
        spajxxMapper.insertSpajxxLog();
        log.info("成功删除向spajxxLog表插入了数据！！！！！！！！！！");
        QueryWrapper<Spajxx> queryWrapper = new QueryWrapper<Spajxx>().eq("1","1");
        List<Spajxx> list=spajxxMapper.selectList(queryWrapper);
       for (Spajxx spa:list
            ) {
           String id=spa.getId();
           i=spajxxMapper.deleteById(id);

       }
       log.info("成功删除"+list.size()+"行数据！！！！！！！！！！");
       return i;
    }
}
