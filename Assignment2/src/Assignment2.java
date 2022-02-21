import java.util.*;

//Search Insert Position
class searchInsertPosition{
    public int searchInsert(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

//Single Element in a Sorted Array
class singleElementinaSortedArray{
    public int singleNonDuplicate(int[] nums){
        for (int i = 0; i < nums.length - 1; i += 2){
            if(nums[i] != nums[i + 1]){
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}

//Find Minimum in Rotated Sorted Array
class findMinimuminRotatedSortedArray{
    public int findMin(int[] nums){
        int low = 0;
        int high = nums.length - 1;
        while (low < high){
            int pivot = low + (high - low) / 2;
            if(nums[pivot] < nums[high]){
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }
}

//Meeting Rooms II
class meetingRoomsII{
    public int minMeetingRooms(int[][] intervals){
        int len = intervals.length;
        int[] start = new int[len];
        int[] end = new int[len];
        for (int i = 0; i < len; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0;
        int j = 0;
        int need = 0;
        int max = 0;
        while (i < len && j < len){
            if(start[i] < end[j]){
                need++;
                i++;
            } else{
                need--;
                j++;
            }
            max = Math.max(max, need);
        }
        return max;
    }
}
//Top K Frequent Elements
class topKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}
//3Sum Closest
class threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] +nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++){
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if(sum > target)
                    end--;
                else if(sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }
}
//Insert Interval
class insertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int len = intervals.length;
        int i = 0;
        while(i < len && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        while(i < len && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);
        while(i < len && intervals[i][0] > newInterval[1]){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
//Non-overlapping Intervals
class nonoverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));

        int res = 0;
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(end <= intervals[i][0])
                end = intervals[i][1];
            else{
                end = Math.min(end, intervals[i][1]);
                res++;
            }
        }
        return res;
    }
}
//Interval List Intersections
class intervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList();
        int i = 0, j = 0;
        while(i < A.length && j < B.length){
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if(lo <= hi)
                ans.add(new int[]{lo, hi});
            if(A[i][1] < B[j][1])
                i++;
            else
                j++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
//4Sum
class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4){
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for(int i = 0; i < length - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            if((long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target){
                break;
            }
            if((long)nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target){
                continue;
            }
            for(int j = i + 1; j < length - 2; j++){
                if(j > i+ 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                if((long)nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target){
                    break;
                }
                if((long)nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target){
                    continue;
                }
                int left = j + 1, right = length - 1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                        left++;
                        while(left < right && nums[right] == nums[right - 1]){
                            right--;
                        }
                        right--;
                    } else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }
}

