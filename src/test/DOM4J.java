package test;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * DOM4J 遍历XML文件
 * 
 * @author 厉昀键 Created on 2017年12月13日 类说明
 *
 */
public class DOM4J {
	
	private static int level;
	
	public static void main(String[] args) {
		try {
			testGetRoot();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// DOM4J 递归遍历xml文件
	
	//头部字符串
	public static String createPrintStr(int level){
		String head = "";
		for (int i = 0; i < level; i++) {
			head = head + "      ";
		}
		return head;
	}
	
	// 获取文件的document对象，然后获取对应的根节点
	public static void testGetRoot() throws Exception {
		SAXReader sax = new SAXReader();// 创建一个SAXReader对象
		File xmlFile = new File("pom.xml");// 根据指定的路径创建file对象
		Document document = sax.read(xmlFile);// 获取document对象,如果文档无节点，则会抛出Exception提前结束
		Element root = document.getRootElement();// 获取根节点
		getNodes(root);// 从根节点开始遍历所有节点
	}

	// 从指定节点开始,递归遍历所有子节点
	public static void getNodes(Element node) {
		System.out.println(createPrintStr(level) + "--------------------");
		// 当前节点的名称、文本内容和属性
		System.out.println(createPrintStr(level) + "当前节点名称：" + node.getName());// 当前节点名称
		System.out.println(createPrintStr(level) + "当前节点的内容：" + node.getTextTrim());// 当前节点名称
		List<Attribute> listAttr = node.attributes();// 当前节点的所有属性的list
		for (Attribute attr : listAttr) {// 遍历当前节点的所有属性
			String name = attr.getName();// 属性名称
			String value = attr.getValue();// 属性的值
			System.out.println(createPrintStr(level) + "属性名称：" + name + "  属性值：" + value);
		}
		System.out.println(createPrintStr(level) + "--------------------");

		// 递归遍历当前节点所有的子节点
		List<Element> listElement = node.elements();// 所有一级子节点的list
		for (Element e : listElement) {// 遍历所有一级子节点
			level++;
			getNodes(e);// 递归
			level--;
		}
	}
}
