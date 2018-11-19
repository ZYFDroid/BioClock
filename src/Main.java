import java.util.*;

public class Main
{
	public static void main(String[] args) throws InterruptedException
	{
		Date birth=new Date(2000-1900,11-1,15,17,5,0);
		System.out.println("生日:"+birth.toLocaleString());
		Date now=new Date();
		System.out.println("当前:"+now.toLocaleString());
		BioClock bioclock=new BioClock(birth);
		System.out.println("智力周期=\t"+bioclock.getIntelligenceLevel());
		System.out.println("情绪周期=\t"+bioclock.getMoodLevel());
		System.out.println("体力周期=\t"+bioclock.getStaminaLevel());
		Thread.sleep(100);
	}
}
class BioClock{
	private Date mBirthday=null;
	public BioClock(Date birthday){
		mBirthday=birthday;
	}
	private double getValueWithInterval(Date current,double interval){
		double dayBetween=(current.getTime()-mBirthday.getTime());
		dayBetween=dayBetween/86400d/1000d;
		return Math.sin(dayBetween/interval*Math.PI*2d);
	}
	
	//智力周期
	public double getIntelligenceLevel(Date time){
		return getValueWithInterval(time,33d);
	}
	public double getIntelligenceLevel(){
		return getIntelligenceLevel(new Date());
	}
	
	//情绪周期
	public double getMoodLevel(Date time){
		return getValueWithInterval(time,28d);
	}
	public double getMoodLevel(){
		return getMoodLevel(new Date());
	}
	
	//体力周期
	public double getStaminaLevel(Date time){
		return getValueWithInterval(time,23d);
	}
	public double getStaminaLevel(){
		return getStaminaLevel(new Date());
	}
}
