import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestFile2 {
	public static void main3(String[] args) throws IOException{
		int a=1;
		int b=3;
		int c=a/b;
		
		System.out.println(c);
		
	}
	public static void main(String[] args) throws IOException{
		System.out.print("当天工程相对路径\n"); 
		String projectPath=System.getProperty("user.dir");
		System.out.print(projectPath);
		
		File helo= new File("D:/D/com_pansky工作/工商数据对比/地税要求数据股东（2012-03-31）.txt");
		File ff= new File(projectPath+"/src/aaa.txt");

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(helo)));
		FileWriter fw = new FileWriter(ff,true);
		String data = null;
		String ttt="";
		int i=0;
		String ttts[]=null;
		String tempt="";
		fw.flush();
		String errorStr=null;
		while((data = br.readLine())!=null)
		{
			if(data.contains("410491000002718")||data.contains("410491000013267")||data.contains("410500000007474")){
				errorStr=data.replace("\n", "");
				continue;
			}
			if(errorStr!=null){
				ttts=(errorStr+data).split(",");
				errorStr=null;
			}else{
				ttts=data.split(",");
			}
			tempt=ttts[0]+","+ttts[2]+","+ttts[6]+","+ttts[7]+","+ttts[9]+","+ttts[10]+","+ttts[11]+","+ttts[12]+"\n";
			tempt=tempt.replace("\"", "");
			tempt=tempt.replace("[", "");
			tempt=tempt.replace("]", "");
			tempt=tempt.replace(" 00:00:00.0", "");
			tempt=tempt.replace("-", "/");
			tempt=tempt.replace(" ", "");
			
			fw.write(tempt);
			fw.flush();
			i++;
		}
		System.out.println("count:"+i); 
	}
	public static void main2(String[] args) throws IOException{
		System.out.print("当天工程相对路径\n"); 
		String projectPath=System.getProperty("user.dir");
		System.out.print(projectPath);

		File helo= new File(projectPath+"/src/hello.txt");
		long size=1024*10*1000;
		try {
			FileDivisionUniter.divide(projectPath+"/src/hello.txt", size);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main1(String[] args) throws IOException{
		System.out.print("当天工程相对路径\n"); 
		String projectPath=System.getProperty("user.dir");
		System.out.print(projectPath);
		File net= new File("D:\\etaxworkspace\\IOTest\\src\\ttt.txt");
		File helo= new File("D:\\etaxworkspace\\IOTest\\src\\ttt.txt");
//		File ff= new File(projectPath+"/src/企业信息格式.txt");
		File ff= new File("D:/D/com_pansky工作/工商数据对比/地税要求数据（2012-03-31）.txt");
//		System.out.print("\n第一种方法：FileReader\n"); 
		FileReader fr = new FileReader(helo);
			
		
//		char[] buffer = new char[1024];
//		int ch = 0;
//		while((ch = fr.read())!=-1 )
//		{
//			System.out.print((char)ch); 
//		}w
//		/*
//		 * 其中read()方法返回的是读取得下个字符。
//		 * 当然你也可以使用read(char[] ch,int off,int length)这和处理二进制文件的时候类似，不多说了。
//		 * 如果使用InputStreamReader来读取文件的时候
//		 */
//		System.out.print("\n第二种方法：InputStreamReader\n"); 
//		InputStreamReader isr = new InputStreamReader(new FileInputStream(ff));
//		while((ch = isr.read())!=-1)
//		{
//			System.out.print((char)ch); 
//		} 
//		/*
//		 *这和FileReader并没有什么区别，事实上在FileReader中的方法都是从InputStreamReader中继承过来的。
//		 *read()方法是比较好费时间的，如果为了提高效率我们可以使用BufferedReader对Reader进行包装，
//		 *这样可以提高读取得速度，我们可以一行一行的读取文本，使用readLine()方法。
//		 */
//		System.out.print("\n第三种方法:BufferedReader\n"); 
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(ff)));
		FileWriter fw = new FileWriter(helo,true);
		String data = null;
		String data_a[]=null;
		StringBuffer buffer=new StringBuffer();
		String ttt="";
		int i=0;
		while((data = br.readLine())!=null)
		{
			ttt=data.replace("\"", "");
			ttt=ttt.replace("[", "");
			ttt=ttt.replace("]", "");
			ttt=ttt.replace(" 00:00:00.0", "");
			ttt=ttt.replace("-", "/");
			ttt=ttt.replace(" ", "");

			ttt+="\n";
			fw.write(ttt);
			fw.flush();
			i++;
		}
		System.out.println("count:"+i); 
		/*
		 * 当你明白了如何用Reader来读取文本文件的时候那么用Writer写文件同样非常简单。
		 * 有一点需要注意，当你写文件的时候，为了提高效率，写入的数据会先放入缓冲区，然后写入文件。
		 * 因此有时候你需要主动调用flush()方法。与上面对应的写文件的方法为：
		 */
	
//		FileWriter fw = new FileWriter(helo,true);
//		String content = buffer.toString();
//		for(int j=0;j<1315;j++){
//			fw.write(content);
//			fw.flush();
//		}

//		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(helo));
//		osw.write(s,0,s.length());
//		osw.flush();


		//不要忘记用完后关闭流！
		fr.close();
//		isr.close();
		br.close();
		fw.close();
//		osw.close();
		}
}