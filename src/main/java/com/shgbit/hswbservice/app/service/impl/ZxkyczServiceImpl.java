package com.shgbit.hswbservice.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shgbit.hswbservice.app.entity.*;
import com.shgbit.hswbservice.app.mapper.ZxkyczMapper;
import com.shgbit.hswbservice.app.service.IZxkyczService;
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
import zxkyc.ZxKycServices;
import zxkyc.ZxKycServices_Service;

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
public class ZxkyczServiceImpl extends ServiceImpl<ZxkyczMapper, Zxkycz> implements IZxkyczService {
    @Autowired
    ZxkyczMapper zxkyczMapper;
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int deleteAndInsert() {
        int i=0;
        deleteZxkyc();
        i=insetZxkyc();
        return  i;
    }

    @Override
    public int insetZxkyc() {
        //创建视图
        ZxKycServices_Service zxKycServices_service=new ZxKycServices_Service();
        //获取服务实现类
        ZxKycServices zxKycServices=zxKycServices_service.getPort(ZxKycServices.class);
        //获取年份xml
        String s=zxKycServices.getAllSANH();
        log.info("执行案件信息获取年份xml:===="+s);
        XmlReader xmlReader=new XmlReader();

        //返回年份列表
        List<Integer> list=xmlReader.getNDH(s);
        for (Integer i:list
                ) {
            log.info("执行案件信息年份：========"+i.toString());
            //返回案件数据xmlStr
            String xmlStr=zxKycServices.getDataByNDH(i.toString());
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
            xstream.allowTypes(new Class[]{ZxkyczList.class, Zxkycz.class});
            //设置安全性
            xstream.autodetectAnnotations(true);
            xstream.processAnnotations(ZxkyczList.class);
            //获取实体类列表
            ZxkyczList zxkyczList= (ZxkyczList) xstream.fromXML(xmlStr);
            if(zxkyczList!=null) {
                log.info(i+"年获取到"+zxkyczList.getZxkyczList().size()+"条数据！！！！！！！！！！！！！！");
                for (Zxkycz zxkycz : zxkyczList.getZxkyczList()
                        ) {
                    int j=0;
                    LocalDateTime time = LocalDateTime.now();
                    zxkycz.setId(UUID.randomUUID().toString().replace("-", "").toLowerCase());
                    zxkycz.setUpdatetime(time);

                    j = zxkyczMapper.insert(zxkycz);
                }
            }

        }
        log.info("接口调用完毕并插库成功");
        return 0;
    }

    @Override
    public int deleteZxkyc() {
        int i=0;
        zxkyczMapper.insertZxkyczLog();
        log.info("成功删除向spajxxLog表插入了数据！！！！！！！！！！");
        QueryWrapper<Zxkycz> queryWrapper = new QueryWrapper<Zxkycz>().eq("1","1");
        List<Zxkycz> list=zxkyczMapper.selectList(queryWrapper);
        for (Zxkycz zxkycz:list
                ) {
            String id=zxkycz.getId();
            i=zxkyczMapper.deleteById(id);

        }
        log.info("成功删除"+list.size()+"行数据！！！！！！！！！！");
        return i;
    }
}
