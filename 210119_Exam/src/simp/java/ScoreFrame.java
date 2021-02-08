package simp.java;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScoreFrame extends JFrame{
    JTextField javaScoreText = new JTextField(10);
    JTextField sqlScoreText = new JTextField(10);
    JTextField totalText = new JTextField(10);
    JTextField averageText = new JTextField(10);
    
    public ScoreFrame(){
    	//기본 크기, 배열, 위치, 종료 조건 설정
        setTitle("문제 7");
        setSize(400,300);
        setLayout(new GridLayout(4,1));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //설명 panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        JLabel label = new JLabel("점수를 입력하세요");
        label.setFont(new Font("Sansefira", Font.PLAIN, 40));
        mainPanel.add(label);
        
        //입력 panel
        JPanel inputPanel = new JPanel();
        JLabel jScoreLabel = new JLabel("자바: ");
        JLabel sScoreLabel = new JLabel("SQL: ");
        JLabel sum = new JLabel("총점: ");
        JLabel avg = new JLabel("평균: ");
        inputPanel.add(jScoreLabel);
        inputPanel.add(javaScoreText);
        inputPanel.add(sScoreLabel);
        inputPanel.add(sqlScoreText);
        
        //버튼 panel
        JPanel btnPanel = new JPanel();
        JButton cal = new JButton("계산하기");
        cal.setSize(30,5);
        cal.addActionListener(new ActionHandler());
        btnPanel.add(cal);
        
        //계산 결과 panel
        JPanel resultPanel = new JPanel();
        resultPanel.add(sum);
        resultPanel.add(totalText);
        resultPanel.add(avg);
        resultPanel.add(averageText);
        
        add(mainPanel);
        add(inputPanel);
        add(btnPanel);
        add(resultPanel);
    }
    
    //버튼 ActionListener 내부 클래스
    private class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	//각 점수를 textfield에서 가져와서 정수로 변환하여 대입
            int java = Integer.parseInt(javaScoreText.getText());
            int sql = Integer.parseInt(sqlScoreText.getText());
            //String으로 바꿔주기 위해 [+""]를 붙임
            totalText.setText(java+sql+"");
            averageText.setText((double)((java+sql)/2.0) + "");
        }
    }
}