package leetcode;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2019/11/15
 **/
public class ReverseListNode {


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;

//        listNode2.next = listNode3;
//
//        listNode3.next = listNode4;


        ListNode res = ReverseList(listNode1);

        System.out.println("");
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode ReverseList(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode p, tail, r = null;
        p = head.next;
        //只有一个节点，直接返回
        if (p == null) {
            return head;
        }
        tail = p.next;
        //第一次
        p.next = head;
        head.next = null;
        //只有两个节点
        if (tail == null) {
            return p;
        } else {
            r = tail.next;
        }
        while (r != null) {
            tail.next = p;
            p = tail;
            tail = r;
            r = r.next;
        }
        //最后一个节点
        tail.next = p;
        return tail;
    }

}
//                            _ooOoo_  
//                           o8888888o  
//                           88" . "88  
//                           (| -_- |)  
//                            O\ = /O  
//                        ____/`---'\____  
//                      .   ' \\| |// `.  
//                       / \\||| : |||// \  
//                     / _||||| -:- |||||- \  
//                       | | \\\ - /// | |  
//                     | \_| ''\---/'' | |  
//                      \ .-\__ `-` ___/-. /  
//                   ___`. .' /--.--\ `. . __  
//                ."" '< `.___\_<|>_/___.' >'"".  
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
//                 \ \ `-. \_ __\ /__ _/ .-` / /  
//         ======`-.____`-.___\_____/___.-`____.-'======  
//                            `=---='  
//  
//         .............................................  
//                  佛祖镇楼                  BUG辟易  
//          佛曰:  
//                  写字楼里写字间，写字间里程序员；  
//                  程序人员写程序，又拿程序换酒钱。  
//                  酒醒只在网上坐，酒醉还来网下眠；  
//                  酒醉酒醒日复日，网上网下年复年。  
//                  但愿老死电脑间，不愿鞠躬老板前；  
//                  奔驰宝马贵者趣，公交自行程序员。  
//                  别人笑我忒疯癫，我笑自己命太贱；  
//                  不见满街漂亮妹，哪个归得程序员？ 