//package com.shgbit.hswbservice;
//
//import com.shgbit.hswbservice.app.entity.Spajxx;
//import com.shgbit.hswbservice.app.entity.SpajxxList;
//import com.shgbit.hswbservice.app.service.impl.*;
//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.xml.DomDriver;
//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.io.SAXReader;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.stereotype.Service;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class HswbserviceApplicationTests {
//@Autowired
//SpajxxServiceImpl spajxxService;
//@Autowired
//SpdsrsjServiceImpl spdsrsjService;
//@Autowired
//    ZxajxxServiceImpl zxajxxService;
//@Autowired
//    ZxdsrServiceImpl zxdsrService;
//@Autowired
//    ZxkyczServiceImpl zxkyczService;
//	@Test
//	public void contextLoads() {
//		Document doc =null;
//		//读取解析xml
//		SAXReader reader=new SAXReader();
//		try {
//			doc=reader.read("file:///E:/myproject/xml/NDH.xml");
//			String str=doc.asXML();
//			XStream xstream=new XStream(new DomDriver());
//			XStream.setupDefaultSecurity(xstream);
//			xstream.allowTypes(new Class[]{SpajxxList.class, Spajxx.class});
//
//			xstream.autodetectAnnotations(true);
//			xstream.processAnnotations(SpajxxList.class);
////			SpajxxList carInfos = (SpajxxList) xstream.fromXML("file:///E:/myproject/xml/NDH.xml");
//			SpajxxList carInfos = (SpajxxList) xstream.fromXML(str);
//			for (Spajxx s:carInfos.getSpajxxList()
//				 ) {
//				System.out.println(s.getAh());
//
//			}
//		} catch (DocumentException e) {
//			e.printStackTrace();
//		}
//	}
//	@Test
//	public void testSpajxxService(){
////		SpajxxServiceImpl spajxxService=new SpajxxServiceImpl();
//
//		spajxxService.insetSpajxx();
//	}
//
//	@Test
//	public void testdeleteSpajxxService(){
////		SpajxxServiceImpl spajxxService=new SpajxxServiceImpl();
////        System.out.println(spajxxService.deleteAndInsert());
////        System.out.println(spdsrsjService.deleteAndInsert());
//        System.out.println(zxajxxService.deleteAndInsert());
////        System.out.println(zxdsrService.deleteAndInsert());
////		System.out.println(zxkyczService.deleteAndInsert());
//	}
//
//}
//
