package leetcode;

import java.util.HashMap;
import java.util.Map;
/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * @author Lowry
 *
 */
public class MaxPointsonaLine {
	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public int maxPoints(Point[] points) {
		int m = points.length;
		if (m <= 2)
			return m;
		int max = 2;
		for (int i = 0; i < m; i++) {
			Map<Double, Integer> map = new HashMap<>();
			Point src = points[i];
			int repeat = 0;
			for (int j = i + 1; j < m; j++) {
				Point dst = points[j];
				if (src.x == dst.x && src.y == dst.y)
					repeat++;
				else {
					double key = 0;
					if (src.x == dst.x) {
						key = Double.MAX_VALUE;
					} else if(src.y==dst.y){
					    key = 0;
					}else
						key = (double) (dst.y - src.y) / (dst.x - src.x);
					if (map.containsKey(key)) {
						int value = map.get(key) + 1;
						map.put(key, value);
					} else {
						map.put(key, new Integer(2));
					}
				}
			}
			if(map.keySet().isEmpty()){
				if(repeat+1>max)
					max = repeat+1;
			}
			for (Double k : map.keySet()) {
				if (map.get(k) + repeat > max)
					max = map.get(k) + repeat;
			}
		}
		return max;
	}
	public static void main(String[] args){
		MaxPointsonaLine m = new MaxPointsonaLine();
		Point p1 = m.new Point(1,1);
		Point p2 = m.new Point(1,1);
		Point p3 = m.new Point(1,1);
		Point[] p= {p1,p2,p3};
		System.out.println(m.maxPoints(p));
	}
}
