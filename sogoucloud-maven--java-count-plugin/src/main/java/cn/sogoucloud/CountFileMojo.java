package cn.sogoucloud;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "countFile", defaultPhase = LifecyclePhase.PACKAGE)
public class CountFileMojo extends AbstractMojo {
	@Parameter(property = "path")
	private String path;
	int totalNumberOfFile = 0;// 总文件数量
	int totalNumberOfDiris = 0;// 目录数量
	int totalNumberOfJavaFile = 0;// java文件数量

	public String countFile(String dir) {
		File f = new File(dir);
		File fs[] = f.listFiles();
		if (fs != null) {
			for (int i = 0; i < fs.length; i++) {
				File currenFile = fs[i];
				if (currenFile.isFile()) {
					totalNumberOfFile += 1; // 如果是文件就加1
					String fileName = currenFile.getName();
					String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
					if (suffix.equals("java")) {
						totalNumberOfJavaFile += 1;
					}
				} else {
                    //否则就是目录
					totalNumberOfDiris += 1;
					countFile(currenFile.getAbsolutePath());
				}
			}
		}
		return "totalNumberOfFile:" + totalNumberOfFile + "\ntotalNumberOfDiris:" + totalNumberOfDiris + "\ntotalNumberOfJavaFile:" + totalNumberOfJavaFile;
	}

	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		System.out.println(path);
		System.out.println(countFile(path));
	}
}