package edu.bit.board.page;

public class Criteria {
    // 페이징 처리를 위해선
    private int pageNum;
    private int amount;
    
    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Criteria [pageNum=" + pageNum + ", amount=" + amount + "]";
    }
    
    public Criteria() {
        this(1,10);
    }
    
    
    public Criteria(int pageNum, int amount) {
        this.pageNum=pageNum;
        this.amount=amount; 
    }
    
}
