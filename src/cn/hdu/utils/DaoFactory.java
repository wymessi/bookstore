package cn.hdu.utils;

public class DaoFactory {
	private static DaoFactory instance=new DaoFactory();
	
	private DaoFactory(){
		
	}
	
	public static DaoFactory getInstance(){
		return instance;
	}
	
	public <T> T createDao(String className,Class<T> clazz){
		try{
			
			T t=(T) Class.forName(className).newInstance();
			return t;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
		
	}
}
