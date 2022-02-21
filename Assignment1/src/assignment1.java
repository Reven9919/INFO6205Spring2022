import java.util.*;

class Assignment {
    //SortColors
    class Solution {
        public void sortColors(int[] nums) {
            int n = nums.length;
            int ptr = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[ptr];
                    nums[ptr] = temp;
                    ++ptr;
                }
            }
            for (int i = ptr; i < n; ++i) {
                if (nums[i] == 1) {
                    int temp = nums[i];
                    nums[i] = nums[ptr];
                    nums[ptr] = temp;
                    ++ptr;
                }
            }
        }
    }

    //Majority Element II
    class majorityElement {
        public List<Integer> majorityElement(int[] nums) {
            int element1 = 0;
            int element2 = 0;
            int vote1 = 0;
            int vote2 = 0;

            for (int num : nums) {
                if (vote1 > 0 && num == element1) {
                    vote1++;
                } else if (vote2 > 0 && num == element2) {
                    vote2++;
                } else if (vote1 == 0) {
                    element1 = num;
                    vote1++;
                } else if (vote2 == 0) {
                    element2 = num;
                    vote2++;
                } else {
                    vote1--;
                    vote2--;
                }
            }

            int cnt1 = 0;
            int cnt2 = 0;
            for (int num : nums) {
                if (vote1 > 0 && num == element1) {
                    cnt1++;
                }
                if (vote2 > 0 && num == element2) {
                    cnt2++;
                }
            }

            List<Integer> ans = new ArrayList<>();
            if (vote1 > 0 && cnt1 > nums.length / 3) {
                ans.add(element1);
            }
            if (vote2 > 0 && cnt2 > nums.length / 3) {
                ans.add(element2);
            }
            return ans;
        }
    }

    //H-Index
    class hIndex {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int h = 0, i = citations.length - 1;
            while (i >= 0 && citations[i] > h) {
                h++;
                i--;
            }
            return h;
        }
    }

    //Intersection of Two Arrays
    class IntersectionofTwoArrays {
        public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int length1 = nums1.length;
            int length2 = nums2.length;
            int[] intersection = new int[length1 + length2];
            int index = 0;
            int index1 = 0;
            int index2 = 0;
            while (index1 < length1 && index2 < length2) {
                int num1 = nums1[index1];
                int num2 = nums2[index2];
                if (num1 == num2) {
                    if (index == 0 || num1 != intersection[index - 1]) {
                        intersection[index++] = num1;
                    }
                    index1++;
                    index2++;
                } else if (num1 < num2) {
                    index1++;
                } else {
                    index2++;
                }
            }
            return Arrays.copyOfRange(intersection, 0, index);
        }
    }

    //Find K Closest Elements
    class findClosestElements {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int size = arr.length;
            int left = 0;
            int right = size - 1;
            int removeNums = size - k;
            while (removeNums > 0) {
                if (x - arr[left] <= arr[right] - x) {
                    right--;
                } else {
                    left++;
                }
                removeNums--;
            }
            List<Integer> res = new ArrayList<>();
            for (int i = left; i < left + k; i++) {
                res.add(arr[i]);
            }
            return res;
        }
    }

    //Reorganize String
    class reorganizeString {
        public String reorganizeString(String S) {
            char[] alphabetArr = S.toCharArray();
            int[] alphabetCount = new int[26];
            int length = S.length();
            for (int i = 0; i < length; i++) {
                alphabetCount[alphabetArr[i] - 'a']++;
            }
            int max = 0, alphabet = 0, threshold = (length + 1) / 2;
            for (int i = 0; i < alphabetCount.length; i++) {
                if (alphabetCount[i] > max) {
                    max = alphabetCount[i];
                    alphabet = i;
                    if (max > threshold)
                        return "";
                }
            }
            char[] res = new char[length];
            int index = 0;
            while (alphabetCount[alphabet]-- > 0) {
                res[index] = (char) (alphabet + 'a');
                index += 2;
            }
            for (int i = 0; i < alphabetCount.length; i++) {
                while (alphabetCount[i]-- > 0) {
                    if (index >= res.length) {
                        index = 1;
                    }
                    res[index] = (char) (i + 'a');
                    index += 2;
                }
            }
            return new String(res);
        }
    }

    //Custom Sort String
    class customSortString {
        public String customSortString(String S, String T) {
            int[] count = new int[26];
            for (char c : T.toCharArray())
                count[c - 'a']++;
            StringBuilder ans = new StringBuilder();
            for (char c : S.toCharArray()) {
                for (int i = 0; i < count[c - 'a']; ++i)
                    ans.append(c);
                count[c - 'a'] = 0;
            }
            for (char c = 'a'; c <= 'z'; ++c)
                for (int i = 0; i < count[c - 'a']; ++i)
                    ans.append(c);
            return ans.toString();
        }
    }

    //Pancake Sorting
    class pancakeSorting {
        public List<Integer> pancakeSort(int[] A) {
            List<Integer> ans = new ArrayList();
            int N = A.length;

            Integer[] B = new Integer[N];
            for (int i = 0; i < N; ++i)
                B[i] = i + 1;
            Arrays.sort(B, (i, j) -> A[j - 1] - A[i - 1]);

            for (int i : B) {
                for (int f : ans)
                    if (i <= f)
                        i = f + 1 - i;
                ans.add(i);
                ans.add(N--);
            }
            return ans;
        }
    }

    //Sort Array by Increasing Frequency
    class sortArraybyIncreasingFrequency {
        public int[] frequencySort(int[] nums) {
            int[] cnts = new int[201];
            for (int n : nums) {
                cnts[n + 100]++;
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = 201 * cnts[nums[i] + 100] - nums[i] + 100;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                nums[i] = 100 - nums[i] % 201;
            }
            return nums;
        }
    }

    //Top K Frequent Words
    class topKFrequentWords {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> count = new HashMap();
            for (String word : words) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
            PriorityQueue<String> minHeap = new PriorityQueue<>((s1, s2) -> {
                if (count.get(s1).equals(count.get(s2))) {
                    return s2.compareTo(s1);
                } else {
                    return count.get(s1) - count.get(s2);
                }
            });
            for (String s : count.keySet()) {
                minHeap.offer(s);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
            List<String> res = new ArrayList<String>(k);
            while (minHeap.size() > 0) {
                res.add(minHeap.poll());
            }
            Collections.reverse(res);
            return res;
        }

    }
}
