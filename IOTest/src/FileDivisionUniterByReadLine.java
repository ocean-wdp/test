import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * �ļ��ָ�������һ���ļ��ָ������С�ļ��������С�ļ��ϲ���һ�����ļ�
 * 
 * @author chen
 * 
 */
public class FileDivisionUniterByReadLine {

	public static final String SUFFIX = ".pp"; // �ָ����ļ�����׺

	/**
	 * �ָ��ļ�
	 * 
	 * @param fileName
	 *            ���ָ���ļ���
	 * @param size
	 *            �ָ����������size�н��зָ�
	 * @return �ָ��С�ļ����ļ���
	 * @throws Exception
	 *             �ָ�����п����׳����쳣
	 */
	public static String[] divide(String fileName, long size) throws Exception {
		File inFile = new File(fileName);
		if (!inFile.exists() || inFile.isDirectory()) {
			throw new Exception("ָ���ļ�������!");
		}
		// ��ñ��ָ��ļ����ļ����������ָ�ɵ�С�ļ��ʹ�������Ŀ¼��
		File parentFile = inFile.getParentFile();

		// ȡ���ļ��Ĵ�С
		long fileLength = inFile.length();
		if (size <= 0)
			size = fileLength / 2;

		// ȡ�÷ָ���С�ļ�����Ŀ
		int num = (int) ((fileLength + size - 1) / size);

		// ��ŷָ���С�ļ���
		String[] outFileNames = new String[num];

		FileInputStream in = new FileInputStream(inFile);

		// �������ļ����Ŀ�ʼ�ͽ����±�
		long inEndIndex = 0;
		int inBeginIndex = 0;

		// ����Ҫ�ָ����Ŀ�ָ��ļ�
		for (int outFileIndex = 0; outFileIndex < num; outFileIndex++) {
			// ����ǰoutFileIndex-1���ļ�����С����size
			File outFile = new File(parentFile, inFile.getName() + outFileIndex + SUFFIX);
			FileOutputStream out = new FileOutputStream(outFile);
			inEndIndex += size;
			inEndIndex = (inEndIndex > fileLength) ? fileLength : inEndIndex;
			// ���������ж�ȡ�ֽڴ洢���������
			for (; inBeginIndex < inEndIndex; inBeginIndex++)
				out.write(in.read());
			out.close();
			outFileNames[outFileIndex] = outFile.getAbsolutePath();
		}
		in.close();
		return outFileNames;
	}

	/**
	 * �ϲ��ļ�
	 * 
	 * @param fileNames
	 *            ���ϲ����ļ�������һ������
	 * @param targerFileName
	 *            Ŀ���ļ���
	 * @return Ŀ���ļ���ȫ·��
	 * @throws Exception
	 *             �ϲ������п����׳����쳣
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
		System.out.println("�ָ��ļ�" + fileName + "���");
		for (int i = 0; i < fileNames.length; i++)
			System.out.println(fileNames[i]);

		String newFileName = "c:/test/newtest.txt";
		System.out.println("�ϲ������" + FileDivisionUniterByReadLine.unite(fileNames, newFileName));
	}

}
