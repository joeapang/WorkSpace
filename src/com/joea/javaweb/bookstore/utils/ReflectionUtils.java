package com.joea.javaweb.bookstore.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/***
 * �����Utils�ķ�������
 * �ṩ����˽�б�������ȡ����Class,��ȡ������Ԫ�����Ե�Utils����
 * @author Joea
 *
 */
public class ReflectionUtils {

	
	/***
	 * ͨ�����䣬��ȡ����Classʱ�����ĸ���ķ��Ͳ�������
	 * @param clazz
	 * @param index
	 * @return
	 */
	public static Class getSuperClassGenricType(Class clazz, int index) {
		Type genType = clazz.getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}

	/***
	 * ͨ�����䣬��ȡClass�����������ĸ���ķ��Ͳ�������
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getSuperGenericclass(Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	/***
	 * ѭ������ת�ͣ���ȡ�����DeclaredMethod
	 * @param object
	 * @param methodName
	 * @param parameterType
	 * @return
	 */
	public static Method getDeclaredMethod(Object object, String methodName, Class<?>[] parameterType) {

		for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				return superClass.getDeclaredMethod(methodName, parameterType);
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	/***
	 * ʹfield��Ϊ�ɷ���
	 * @param field
	 */
	public static void makeAccessible(Field field) {
		if (!Modifier.isPublic(field.getModifiers())) {
			field.setAccessible(true);
		}
	}
	/***
	 * ѭ������ת�ͣ���ȡ�����DeclaredField
	 * @param object
	 * @param fieldName
	 * @return
	 */

	public static Field getDeclaredField(Object object, String fieldName) {
		for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				return superClass.getDeclaredField(fieldName);
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	/***
	 * ֱ�ӵ��ö��󷽷����������η���public,private,protected��
	 * @param object
	 * @param methodName
	 * @param parameterType
	 * @param parameters
	 * @return
	 */
	public static Object invokeMthod(Object object, String methodName, Class<?>[] parameterType, Object[] parameters) {
		Method method = getDeclaredMethod(object, methodName, parameterType);

		if (method == null) {
			throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + object + "]");
		}
		
		method.setAccessible(true);
		try {
			return method.invoke(object, parameters);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/***
	 * ֱ�����ö��������ֵ������private/protect���η���Ҳ������setter
	 * @param object
	 * @param fieldName
	 * @param value
	 */
	public static void setFieldValue(Object object ,String fieldName,Object value){
		Field field=getDeclaredField(object, fieldName);
		if(field==null){
			throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");
		}
		
		makeAccessible(field);
		try {
			field.set(object, value);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/***
	 * ֱ�Ӷ�ȡ���������ֵ������private/protect���η���Ҳ������getter
	 * @param object
	 * @param fieldName
	 * @return
	 */
	public static Object getFieldValue(Object object,String fieldName){
		Field field=getDeclaredField(object, fieldName);
		
		if(field ==null){
			throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");
		}
		makeAccessible(field);
		
		Object result=null;
		
		try {
			result=field.get(object);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
