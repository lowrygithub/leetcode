package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SJ {
	public static void main(String[] args){
		int min = Integer.MAX_VALUE;
		int max = 0;
		int sum = 0;
		int count = 0;
		int avg = 0;
		String file = "C:\\Users\\Lowry\\Desktop\\共建\\组推荐\\data\\20factor6040groups";
		try {
			BufferedReader bfw = new BufferedReader(new FileReader(new File(file)));
			String line;
			while((line = bfw.readLine())!=null){
				if(line.indexOf("diff")>=0){
					count++;
					if(count == 1)
						continue;
					String[] lineSplit = line.split(":");
					int num = Integer.parseInt(lineSplit[1]);
					min = num<min?num:min;
					max = num>max?num:max;
					sum +=num;
				}
			}
			avg = sum/(count-1);
			System.out.println(count);
			System.out.println("min:"+min);
			System.out.println("max:"+max);
			System.out.println("avg:"+avg);
			
			bfw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
