package Test;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class JPopupMenuTest extends JFrame {
 public JPopupMenuTest() {    
  JButton button2 = new JButton("101");
  this.add(button2);
  button2.addMouseListener(new MouseAdapter() {
   @Override
   public void mouseReleased(MouseEvent e) {   
    showPopupMenu(e);
   }
  });
  this.setLayout(new FlowLayout());
  this.setBounds(100, 100, 300, 300);
  this.setVisible(true);

 }

 private void showPopupMenu(MouseEvent e) {
  // �����ǰ�¼����Ҽ��˵��йأ������Ҽ������򵯳��˵�
  if (e.isPopupTrigger()) {
   JPopupMenu pop = new JPopupMenu("id1");
   final String sid = ((JButton) e.getComponent()).getText();
   JMenuItem item1 = new JMenuItem("����1");
   item1.addMouseListener(new MouseAdapter(){
    public void mouseReleased(MouseEvent e) {
     System.out.println(sid);
    }
   });
   pop.add(item1);
   //e.getComponent()��ʾ���Ҽ��˵����������������ָbutton2  
   pop.show(e.getComponent(), e.getX(), e.getY());
  }else{//��������������������
   System.out.println("������");
  }
 }

 public static void main(String[] args) {
  new JPopupMenuTest();
 }
}
