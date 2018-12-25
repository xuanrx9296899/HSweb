package com.shgbit.hswbservice.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shgbit.hswbservice.app.entity.Spajxx;
import com.shgbit.hswbservice.app.entity.SpajxxList;
import com.shgbit.hswbservice.app.entity.Zxdsr;
import com.shgbit.hswbservice.app.entity.ZxdsrList;
import com.shgbit.hswbservice.app.mapper.ZxajxxMapper;
import com.shgbit.hswbservice.app.mapper.ZxdsrMapper;
import com.shgbit.hswbservice.app.service.IZxdsrService;
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
import zxdsr.ZxDsrServices;
import zxdsr.ZxDsrServicesImpl;

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
public class ZxdsrServiceImpl extends ServiceImpl<ZxdsrMapper, Zxdsr> implements IZxdsrService {
    @Autowired
    ZxdsrMapper zxdsrMapper;
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int deleteAndInsert() {
        int i=0;
        deleteZxdsr();
        i=insetZxdsr();
        return  i;
    }

    @Override
    public int insetZxdsr() {
        //创建视图
        ZxDsrServicesImpl zxDsrServices=new ZxDsrServicesImpl();
        //获取服务实现类
        ZxDsrServices zxDsrServices1=zxDsrServices.getPort(ZxDsrServices.class);
        //获取年份xml
        String s=zxDsrServices1.getAllSANH();
//        String s="";
        log.info("执行当事人获取年份xml:===="+s);
        XmlReader xmlReader=new XmlReader();

        //返回年份列表
        List<Integer> list=xmlReader.getNDH(s);
        for (Integer i:list
                ) {
            log.info("执行当事人年份：========"+i.toString());
            //返回案件数据xmlStr
            String xmlStr=zxDsrServices1.getDataByNDH(i.toString());
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
            xstream.allowTypes(new Class[]{ZxdsrList.class, Zxdsr.class});
            //设置安全性
            xstream.autodetectAnnotations(true);
            xstream.processAnnotations(ZxdsrList.class);
            //获取实体类列表
            ZxdsrList zxdsrList= (ZxdsrList) xstream.fromXML(xmlStr);
//            System.out.println(spajxxList.getSpajxxList().size());
            if(zxdsrList!=null) {
                log.info(i+"年获取到"+zxdsrList.getZxdsrList().size()+"条数据！！！！！！！！！！！！！！");
                for (Zxdsr zxdsr : zxdsrList.getZxdsrList()
                        ) {
                    LocalDateTime time = LocalDateTime.now();
                    zxdsr.setId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
                    zxdsr.setUpdatetime(time);
                    int j=0;
                    j = zxdsrMapper.insert(zxdsr);
                }
            }

        }
        log.info("接口调用完毕并插库成功");
        return 0;

    }

    @Override
    public int deleteZxdsr() {
        int i=0;
        zxdsrMapper.insertZxdsrLog();
        log.info("成功删除向zxadsrLog表插入了数据！！！！！！！！！！");
        QueryWrapper<Zxdsr>queryWrapper=new QueryWrapper<Zxdsr>().eq("1","1");
        List<Zxdsr>list=zxdsrMapper.selectList(queryWrapper);
        for (Zxdsr zxdsr:list
             ) {
            String id=zxdsr.getId();
            i=zxdsrMapper.deleteById(id);

        }
        log.info("成功删除"+list.size()+"行数据！！！！！！！！！！");
        return i;
    }
}
