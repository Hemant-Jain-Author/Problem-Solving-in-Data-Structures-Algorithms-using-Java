var MedianHeap = /** @class */ (function () {
    function MedianHeap() {
        if (this.minHeap === undefined)
            this.minHeap = null;
        if (this.maxHeap === undefined)
            this.maxHeap = null;
        this.minHeap = (new java.util.PriorityQueue());
        this.maxHeap = (new java.util.PriorityQueue((java.util.Collections.reverseOrder())));
    }
    MedianHeap.prototype.insert = function (value) {
        if (this.maxHeap.size() === 0 || this.maxHeap.peek() >= value) {
            this.maxHeap.add(value);
        }
        else {
            this.minHeap.add(value);
        }
        if (this.maxHeap.size() > this.minHeap.size() + 1) {
            value = this.maxHeap.remove();
            this.minHeap.add(value);
        }
        if (this.minHeap.size() > this.maxHeap.size() + 1) {
            value = this.minHeap.remove();
            this.maxHeap.add(value);
        }
    };
    MedianHeap.prototype.getMedian = function () {
        if (this.maxHeap.size() === 0 && this.minHeap.size() === 0)
            return 2147483647;
        if (this.maxHeap.size() === this.minHeap.size())
            return ((this.maxHeap.peek() + this.minHeap.peek()) / 2 | 0);
        else if (this.maxHeap.size() > this.minHeap.size())
            return this.maxHeap.peek();
        else
            return this.minHeap.peek();
    };
    MedianHeap.main = function (args) {
        var arr = [1, 9, 2, 8, 3, 7, 4, 6, 5, 1, 9, 2, 8, 3, 7, 4, 6, 5, 10, 10];
        var hp = new MedianHeap();
        for (var i = 0; i < 20; i++) {
            {
                hp.insert(arr[i]);
                console.info("Median after insertion of " + arr[i] + " is  " + hp.getMedian());
            }
            ;
        }
    };
    return MedianHeap;
}());
MedianHeap["__class"] = "MedianHeap";
MedianHeap.main(null);
