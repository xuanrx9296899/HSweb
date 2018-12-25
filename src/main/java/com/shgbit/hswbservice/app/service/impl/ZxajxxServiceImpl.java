package com.shgbit.hswbservice.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shgbit.hswbservice.app.entity.Spajxx;
import com.shgbit.hswbservice.app.entity.SpajxxList;
import com.shgbit.hswbservice.app.entity.Zxajxx;
import com.shgbit.hswbservice.app.entity.ZxajxxList;
import com.shgbit.hswbservice.app.mapper.ZxajxxMapper;
import com.shgbit.hswbservice.app.service.IZxajxxService;
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
import szxajxx.ZxAjServices;
import szxajxx.ZxAjServices_Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuanrxupup
 * @since 2018-12-20
 */
@Service
@Slf4j
@Transactional
public class ZxajxxServiceImpl extends ServiceImpl<ZxajxxMapper, Zxajxx> implements IZxajxxService {
    @Autowired
    ZxajxxMapper zxajxxMapper;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int deleteAndInsert() {
        int i=0;
        deletZxajxx();
        i=insetZxajxx();
        return  i;
    }

    @Override
    public int insetZxajxx() {
        //创建视图
        ZxAjServices_Service zxAjServices_service=new ZxAjServices_Service();
        //获取服务实现类
        ZxAjServices zxAjServices=zxAjServices_service.getPort(ZxAjServices.class);
        //获取年份xml
        String s=zxAjServices.getAllSANH();
//        String s="";
        log.info("执行案件信息获取年份xml:===="+s);
        XmlReader xmlReader=new XmlReader();

        //返回年份列表
        List<Integer> list=xmlReader.getNDH(s);
        for (Integer i:list
                ) {
            log.info("执行案件信息年份：========"+i.toString());
            //返回案件数据xmlStr
            String xmlStr=zxAjServices.getDataByNDH(i.toString());
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
            xstream.allowTypes(new Class[]{ZxajxxList.class, Zxajxx.class});
            //设置安全性
            xstream.autodetectAnnotations(true);
            xstream.processAnnotations(ZxajxxList.class);
            //获取实体类列表
            ZxajxxList zxajxxList= (ZxajxxList) xstream.fromXML(xmlStr);
            if(zxajxxList!=null) {
                log.info(i+"年获取到"+zxajxxList.getZxajxxList().size()+"条数据！！！！！！！！！！！！！！");
                for (Zxajxx zxajxx : zxajxxList.getZxajxxList()
                        ) {
                    LocalDateTime time = LocalDateTime.now();
                    zxajxx.setUpdatetime(time);
                    zxajxx.setId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
                    int j=0;

                    j = zxajxxMapper.insert(zxajxx);
                }
            }

        }
        log.info("接口调用完毕并插库成功");
        return 0;


    }

    @Override
    public int deletZxajxx() {
        int i=0;
        zxajxxMapper.insertZxajxxLog();
        log.info("成功删除向zxajxx表插入了数据！！！！！！！！！！");
        QueryWrapper<Zxajxx>queryWrapper=new QueryWrapper<Zxajxx>().eq("1","1");
        List<Zxajxx>list=zxajxxMapper.selectList(queryWrapper);
        for (Zxajxx zx:list
             ) {
            String id=zx.getId();
            i=zxajxxMapper.deleteById(id);
        }
        log.info("成功删除"+list.size()+"行数据！！！！！！！！！！");
        return i;
    }
}
