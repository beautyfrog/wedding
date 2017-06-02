package summerlee.wedding;import java.io.IOException;import java.util.Properties;/** * 属性配置工具 *  * @file PropertyPlaceholderConfigurer * @author libin * @Create 2017-01-05 */public class PropertyPlaceholderConfigurer extends 	org.springframework.beans.factory.config.PropertyPlaceholderConfigurer {	private static Properties properties;		@Override	protected void loadProperties(Properties properties) throws IOException {		super.loadProperties(properties);		// 缓存配置信息		PropertyPlaceholderConfigurer.properties = properties;	}		/**	 * 获取配置	 * @param key	 * @return	 */	public static String getValue(String key) {		return properties.getProperty(key);	}}