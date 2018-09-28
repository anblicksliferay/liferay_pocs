package com.liferay.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 * @see    com.liferay.petra.content.ContentUtil
 */
public class ContentUtil {

	public static String get(ClassLoader classLoader, String location) {
		return _instance._get(classLoader, location, false);
	}

	public static String get(
		ClassLoader classLoader, String location, boolean all) {

		return _instance._get(classLoader, location, all);
	}

	public static String get(String location) {
		return _instance._get(location, false);
	}

	public static String get(String location, boolean all) {
		return _instance._get(location, all);
	}

	private ContentUtil() {
		_contentPool = new HashMap<>();
	}

	private String _get(ClassLoader classLoader, String location, boolean all) {
		String content = _contentPool.get(location);

		if (content == null) {
			try {
				content = StringUtil.read(classLoader, location, all);

				_put(location, content);
			}
			catch (IOException ioe) {
				_log.error(ioe, ioe);
			}
		}

		return content;
	}

	private String _get(String location, boolean all) {
		Class<?> clazz = getClass();

		return _get(clazz.getClassLoader(), location, all);
	}

	private void _put(String location, String content) {
		_contentPool.put(location, content);
	}

	private static final Log _log = LogFactoryUtil.getLog(ContentUtil.class);

	private static final ContentUtil _instance = new ContentUtil();

	private final Map<String, String> _contentPool;

}