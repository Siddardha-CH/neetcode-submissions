class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if (max.isEmpty() || max.peek() >= num)
            max.offer(num);
        else
            min.offer(num);
        
        if (min.size() > max.size())
            max.offer(min.poll());
        else if (max.size() > min.size() + 1)
            min.offer(max.poll());
    }
    
    public double findMedian() {
        if (max.size() > min.size())
            return max.peek();
        return (max.peek() + min.peek()) / 2.0;
    }
}
