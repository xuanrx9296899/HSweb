package com.shgbit.hswbservice.utils;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


/**
 * @author xuanrxup
 * @date 2018/12/17  15:40
 * xml转换成对象集合
 */
@Slf4j
public class XmlReader {
    /**
     *
     * @param classUrl  实体类路径
     * @param xml   xml字符串或者xml文件路径
     * @return
     */
    public List<Object> xmlReader(String classUrl,String xml){
        //反射得到类的引用
        Class obj = null;
        //创建list存放多个对象
        List<Object> objectList=new ArrayList<Object>();
        try {
            obj = Class.forName(classUrl);
            Document doc =null;
            //读取解析xml
            SAXReader reader=new SAXReader();
            // 将字符串转为XML
//          doc = DocumentHelper.parseText(xml);
            doc=reader.read(xml);
            //获取根节点
            Element rootElement=doc.getRootElement();
            //利用Element中的方法，获取根节点下的全部子节点.返回一个List<element>
            List<Element> elements = rootElement.elements();
            int j=elements.size();
            Object[]arr=new Object[j];
            //1.遍历list,获得每个元素
            for(int z=0;z<elements.size();z++){
                //得到类对象
                Object objInstance=obj.newInstance();
                Element element=elements.get(z);
                //创建list存放多个对象
//                List<Object> objectList1=new ArrayList<Object>();
                List<Element> objElement = element.elements();
                for (Element objElementData : objElement) {
                    //得到每个子节点的名字
                    String elementName = objElementData.getName();
                    //遍历并获得每个子元素的文本内容,如得到name子节点的文本值为Claire
                    String objData = objElementData.getStringValue();
                    // 通过elemetname得到对应的get set方法，先拼接出方法名，比如 name--setName
                    String funName = "set" + (elementName.charAt(0)+"").toUpperCase()+elementName.substring(1).toLowerCase();
                    //通过方法名反射出方法对象
                    Method method1 = obj.getDeclaredMethod(funName, String.class);
                    //通过反射调用方法，调用stuInstance对象的method方法，参数为stuData---给各属性赋值
                    method1.invoke(objInstance, objData);
                }
                arr[z]=objInstance;
            }
            for(int i=0;i<arr.length;i++){
                objectList.add(arr[i]);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
       return objectList;
    }

    public List<Integer> getNDH(String xmlStr){
        List<Integer>list=new ArrayList<Integer>();
        Document doc =null;
        //读取解析xml
        SAXReader reader=new SAXReader();
        try {
            // 将字符串转为XML
//            doc=reader.read("file:///E:/myproject/xml/Year.xml");
            doc = DocumentHelper.parseText(xmlStr);
            //获取根节点
            Element rootElement=doc.getRootElement();
            //利用Element中的方法，获取根节点下的全部子节点.返回一个List<element>
            List<Element> elements = rootElement.elements();
            for (Element element:elements) {
                String s=element.getStringValue();
                Integer i=null;
                i=Integer.valueOf(s);
                list.add(i);

            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return list;
    }
//    private static void readXmlFun() throws DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
//        //反射得到类的引用
//        Class spajxx =Class.forName("com.shgbit.hsnewws.entity.Spajxx");
//        //得到类对象
//        Object spInstance=spajxx.newInstance();
//        //创建list存放多个student
//        List<Spajxx> spajxxes=new ArrayList<Spajxx>();
//        Document doc =null;
//        //读取解析xml
//        SAXReader reader=new SAXReader();
//        doc=reader.read("file:///E:/myproject/xml/NDH.xml");
//        //获取根节点
//        Element rootElement=doc.getRootElement();
//        //利用Element中的方法，获取根节点下的全部子节点.返回一个List<element>
//        List<Element> elements = rootElement.elements();
//        //1.遍历list,获得每个元素
//        for (Element element : elements) {
//            List<Element> subElement = element.elements();
//            for (Element subElementData : subElement) {
//                //得到每个子节点的名字
//                String elementName = subElementData.getName();
//                //遍历并获得每个子元素的文本内容,如得到name子节点的文本值为Claire
//                String stuData = subElementData.getStringValue();
////                System.out.println(elementName +"为" + stuData);
//
//
//                //通过elemetname得到对应的get set方法，先拼接出方法名，比如 name--setName
//                String funName = "set" + (elementName.charAt(0)+"").toUpperCase()+elementName.substring(1);
//
//                //通过方法名反射出方法对象
//                Method method1 = spajxx.getDeclaredMethod(funName, String.class);
//                //通过反射调用方法，调用stuInstance对象的method方法，参数为stuData---给各属性赋值
//                method1.invoke(spInstance, stuData);
//            }
//            spajxxes.add((Spajxx)spInstance);
//            System.out.println(spajxxes);
//        }
//        for (Spajxx spaj:spajxxes) {
//            Spajxx spajxx1=new Spajxx();
////            int j=spajxxMapper.insert(spajxx1);
//        }
//
//
//
//
//    }

}
