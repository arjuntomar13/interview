package tinyURL;

public class TinyUrl {
	
	String tinyUrlMap = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	String getTinyUrl(int id){
		
		String tinyUrl = "";
		StringBuilder digits = new StringBuilder();
		
		while(id > 0){
			int remainder = id % 62;
			digits = digits.append(remainder);
			digits.append(",");
			id = id/62;
		}
		
		String[] arr = digits.toString().split(",");
		for(int i = (arr.length-1); i >=0 ; i--){
			tinyUrl = tinyUrl + tinyUrlMap.charAt(Integer.parseInt(arr[i]));
		}
		
		return tinyUrl;
	}
	
	int getId(String ty){
		int[] revArr = new int[ty.length()];
		
		for (int i = 0; i < revArr.length; i++) {
			revArr[i]= tinyUrlMap.indexOf(ty.charAt(i));
		}
		int id = 0;
		for (int i = 0; i < revArr.length; i++) {
			id = id + revArr[i] * (int)Math.pow(62, (revArr.length-1)-i);
			
		}
		return id;
	}

	public static void main(String[] args) {
		TinyUrl ty = new TinyUrl();
		int id = 521;
		System.out.println("Get tiny Url for id  :: " + id);
		String tinyUrl = ty.getTinyUrl(id);
		System.out.println("Tiny Url is : " + tinyUrl);
		int id1 = ty.getId(tinyUrl);
		System.out.println("Getting id back : id :: " + id1);
	}
}
