package misc;

import java.io.File;

public class Test3 {

	public static void main(String[] args) {
		///RDNG_VLTPKG2/5772256977a5640dc8cc9b79/vij_test2-29/29/vij_test2-29.zip
        String path = "\\RDNG_VLTPKG2\\5772256977a5640dc8cc9b79\\vij_test2-29\\29\\vij_test2-29.zip";
        String id = "29";
        String temp = path.substring(path.lastIndexOf(File.separator));
        System.out.println(temp);
        
        System.out.println(temp.lastIndexOf(id)+id.length());
        System.out.println((temp.substring(temp.lastIndexOf("29")+"29".length())));
        System.out.println((temp.substring(temp.lastIndexOf("29")+"29".length())).replace(".zip",""));
        temp = (temp.substring(temp.lastIndexOf("29")+"29".length())).replace(".zip","").replace("-","");
        System.out.println(temp);
	}
}
