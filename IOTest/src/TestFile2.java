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
		System.out.print("���칤�����·��\n"); 
		String projectPath=System.getProperty("user.dir");
		System.out.print(projectPath);
		
		File helo= new File("D:/D/com_pansky����/�������ݶԱ�/��˰Ҫ�����ݹɶ���2012-03-31��.txt");
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
		System.out.print("���칤�����·��\n"); 
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
		System.out.print("���칤�����·��\n"); 
		String projectPath=System.getProperty("user.dir");
		System.out.print(projectPath);
		File net= new File("D:\\etaxworkspace\\IOTest\\src\\ttt.txt");
		File helo= new File("D:\\etaxworkspace\\IOTest\\src\\ttt.txt");
//		File ff= new File(projectPath+"/src/��ҵ��Ϣ��ʽ.txt");
		File ff= new File("D:/D/com_pansky����/�������ݶԱ�/��˰Ҫ�����ݣ�2012-03-31��.txt");
//		System.out.print("\n��һ�ַ�����FileReader\n"); 
		FileReader fr = new FileReader(helo);
			
		
//		char[] buffer = new char[1024];
//		int ch = 0;
//		while((ch = fr.read())!=-1 )
//		{
//			System.out.print((char)ch); 
//		}w
//		/*
//		 * ����read()�������ص��Ƕ�ȡ���¸��ַ���
//		 * ��Ȼ��Ҳ����ʹ��read(char[] ch,int off,int length)��ʹ���������ļ���ʱ�����ƣ�����˵�ˡ�
//		 * ���ʹ��InputStreamReader����ȡ�ļ���ʱ��
//		 */
//		System.out.print("\n�ڶ��ַ�����InputStreamReader\n"); 
//		InputStreamReader isr = new InputStreamReader(new FileInputStream(ff));
//		while((ch = isr.read())!=-1)
//		{
//			System.out.print((char)ch); 
//		} 
//		/*
//		 *���FileReader��û��ʲô������ʵ����FileReader�еķ������Ǵ�InputStreamReader�м̳й����ġ�
//		 *read()�����ǱȽϺ÷�ʱ��ģ����Ϊ�����Ч�����ǿ���ʹ��BufferedReader��Reader���а�װ��
//		 *����������߶�ȡ���ٶȣ����ǿ���һ��һ�еĶ�ȡ�ı���ʹ��readLine()������
//		 */
//		System.out.print("\n�����ַ���:BufferedReader\n"); 
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
		 * ���������������Reader����ȡ�ı��ļ���ʱ����ô��Writerд�ļ�ͬ���ǳ��򵥡�
		 * ��һ����Ҫע�⣬����д�ļ���ʱ��Ϊ�����Ч�ʣ�д������ݻ��ȷ��뻺������Ȼ��д���ļ���
		 * �����ʱ������Ҫ��������flush()�������������Ӧ��д�ļ��ķ���Ϊ��
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


		//��Ҫ���������ر�����
		fr.close();
//		isr.close();
		br.close();
		fw.close();
//		osw.close();
		}
}