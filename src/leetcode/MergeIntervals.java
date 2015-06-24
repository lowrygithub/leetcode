package leetcode;

import java.util.ArrayList;
import java.util.List;

class Interval {
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
	  }
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        for(int i=0;i<intervals.size();i++){
        	int start = intervals.get(i).start;
        	int end= intervals.get(i).end;
        	int insertIndex;
        	for(insertIndex=0;insertIndex<result.size();insertIndex++){
        		Interval currentInterval = result.get(insertIndex);
        		if(start<=currentInterval.start){
        			break;
        		}
        		if(start<=currentInterval.end){
        			start =currentInterval.start;
        			break;
        		}
        	}
        	int endIndex;
        	for(endIndex = insertIndex;endIndex<result.size();){
        		Interval currentInterval = result.get(insertIndex);
        		if(end<currentInterval.start){
        			break;
        		}
        		result.remove(endIndex);
        		if(end<currentInterval.end){
        			end = currentInterval.end;
        			break;
        		}
        	}
        	
        	result.add(insertIndex, new Interval(start, end));
        	
        }
        return result;
    }
}
