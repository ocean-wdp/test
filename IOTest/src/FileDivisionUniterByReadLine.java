import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 文件分割器，将一个文件分割成若干小文件，将多个小文件合并到一个大文件
 * 
 * @author chen
 * 
 */
public class FileDivisionUniterByReadLine {

	public static final String SUFFIX = ".pp"; // 分割后的文件名后缀

	/**
	 * 分割文件
	 * 
	 * @param fileName
	 *            待分割的文件名
	 * @param size
	 *            分割的行数，按size行进行分割
	 * @return 分割后小文件的文件名
	 * @throws Exception
	 *             分割过程中可能抛出的异常
	 */
	public static String[] divide(String fileName, long size) throws Exception {
		File inFile = new File(fileName);
		if (!inFile.exists() || inFile.isDirectory()) {
			throw new Exception("指定文件不存在!");
		}
		// 获得被分割文件父文件，将来被分割成的小文件就存放在这个目录下
		File parentFile = inFile.getParentFile();

		// 取得文件的大小
		long fileLength = inFile.length();
		if (size <= 0)
			size = fileLength / 2;

		// 取得分割后的小文件的数目
		int num = (int) ((fileLength + size - 1) / size);

		// 存放分割后的小文件名
		String[] outFileNames = new String[num];

		FileInputStream in = new FileInputStream(inFile);

		// 读输入文件流的开始和结束下标
		long inEndIndex = 0;
		int inBeginIndex = 0;

		// 根据要分割的数目分割文件
		for (int outFileIndex = 0; outFileIndex < num; outFileIndex++) {
			// 对于前outFileIndex-1个文件，大小都是size
			File outFile = new File(parentFile, inFile.getName() + outFileIndex + SUFFIX);
			FileOutputStream out = new FileOutputStream(outFile);
			inEndIndex += size;
			inEndIndex = (inEndIndex > fileLength) ? fileLength : inEndIndex;
			// 从输入流中读取字节存储到输出流中
			for (; inBeginIndex < inEndIndex; inBeginIndex++)
				out.write(in.read());
			out.close();
			outFileNames[outFileIndex] = outFile.getAbsolutePath();
		}
		in.close();
		return outFileNames;
	}

	/**
	 * 合并文件
	 * 
	 * @param fileNames
	 *            带合并的文件名，是一个数组
	 * @param targerFileName
	 *            目标文件名
	 * @return 目标文件的全路径
	 * @throws Exception
	 *             合并过程中可能抛出的异常
	 */
	public static String unite(String[] fileNames, String targerFileName) throws Exception {
		File inFile = null;

		File outFile = new File(targerFileName);
		FileOutputStream out = new FileOutputStream(outFile);

		for (int i = 0; i < fileNames.length; i++) {
			inFile = new File(fileNames[i]);
			FileInputStream in = new FileInputStream(inFile);
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
			in.close();
		}
		out.close();
		return outFile.getAbsolutePath();
	}

	public static void main(String[] args) throws Exception {
		String fileName = "c:/test.txt";
		long size = 10;
		String[] fileNames = FileDivisionUniterByReadLine.divide(fileName, size);
		System.out.println("分割文件" + fileName + "结果");
		for (int i = 0; i < fileNames.length; i++)
			System.out.println(fileNames[i]);

		String newFileName = "c:/test/newtest.txt";
		System.out.println("合并结果：" + FileDivisionUniterByReadLine.unite(fileNames, newFileName));
	}

}
