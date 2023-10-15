public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
    if(head==null||left==right){
        return head;
    }
    ListNode current=head,prv=null;
    int count=1;
    while(count!=left){
        prv=current;
        current=current.next;
        count++;
    }
    ListNode start=current;
    while(count!=right){
        current=current.next;
        count++;
    }
    ListNode endTurm=current.next;
    current.next=null;
    ListNode rev=rev(start);
    if(prv!=null){
        prv.next=rev;
    }else{
        head=rev;
    }
    current= rev;
    while(current.next!=null){
        current=current.next;
    }
    current.next=endTurm;
   
    return head;
   
    }
    public ListNode rev(ListNode start){
        ListNode current=start;
        ListNode prv=null;
        while(current!=null){
            ListNode newNode=current.next;
            current.next=prv;
            prv=current;
            current=newNode;
           
        }
        return prv;
    }
}


