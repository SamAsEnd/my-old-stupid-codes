package com.samasend;

//<editor-fold defaultstate="collapsed" desc="import">
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import sun.audio.AudioPlayer;
//</editor-fold>

public class CalcForm extends javax.swing.JFrame {

    private static JMenu dateNtime = null;
    private static final long serialVersionUID = 1L;

    private static void startDateTime() {
        int delay = 1000; //milliseconds
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                dateNtime.setText("                   " + DateFormat.getDateTimeInstance().format(new Date()));
            }
        };
        dateNtime.addActionListener(taskPerformer);
        new Timer(delay, taskPerformer).start();
    }

    
    // <editor-fold defaultstate="collapsed" desc="Sam As End function">
    public boolean cheak() {
        setFocusable(true);
        if (answering) {
            display.setText("");
            answering = false;
            point = false;
        }
        if (display.getText().length() > 12) {
            display.setBackground(Color.red);
            return true;
        } else {
            display.setBackground(Color.white);
            return false;
        }
    }
    char op = ' ';
    double ans = 0;
    boolean point = false;
    boolean answering = false;
    int trig = 0;

    String trig() {
        if (trig == 0) {
            return "Red";
        } else {
            return "Deg";
        }
    }

    double fact(double n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    public void op(char o) {
        double temp;
        try {
            switch (o) {
                case ' ':
                    ans = Double.parseDouble(display.getText());
                    break;
                case '+':
                    ans += Double.parseDouble(display.getText());
                    break;
                case '-':
                    ans -= Double.parseDouble(display.getText());
                    break;
                case '*':
                    ans *= Double.parseDouble(display.getText());
                    break;
                case '/':
                    ans /= Double.parseDouble(display.getText());
                    break;
                case '%':
                    ans %= Double.parseDouble(display.getText());
                    break;
                case '2':
                    temp = Double.parseDouble(display.getText());
                    temp *= temp;
                    display.setText(Double.toString(temp));
                    break;
                case '3':
                    temp = Double.parseDouble(display.getText());
                    temp *= (temp * temp);
                    display.setText(Double.toString(temp));
                    break;
                case '^':
                    ans = Math.pow(ans, Double.parseDouble(display.getText()));
                    break;
                case 'l':
                    temp = Double.parseDouble(display.getText());
                    temp = Math.log10(temp);
                    display.setText(Double.toString(temp));
                    break;
                case 'n':
                    temp = Double.parseDouble(display.getText());
                    temp = Math.log(temp);
                    display.setText(Double.toString(temp));
                    break;
                case 'e':
                    temp = Double.parseDouble(display.getText());
                    temp = Math.pow(Math.E, temp);
                    display.setText(Double.toString(temp));
                    break;
                case 'x':
                    temp = Double.parseDouble(display.getText());
                    temp = Math.pow(10, temp);
                    display.setText(Double.toString(temp));
                    break;
                case 'i':
                    temp = Double.parseDouble(display.getText());
                    display.setText(Integer.toString((int) (temp)));
                    point = false;
                    break;
                case ',':
                    temp = Double.parseDouble(display.getText());
                    if (temp == 0) {
                        display.setBackground(Color.red);
                        return;
                    }
                    temp = 1 / temp;
                    display.setText(Double.toString(temp));
                    break;
                case 's':
                    temp = Double.parseDouble(display.getText());
                    if (trig == 1) {
                        temp = Math.toRadians(temp);
                    }
                    temp = Math.sin(temp);
                    display.setText(String.format("%.4f", temp));
                    break;
                case 'c':
                    temp = Double.parseDouble(display.getText());
                    if (trig == 1) {
                        temp = Math.toRadians(temp);
                    }
                    temp = Math.cos(temp);
                    display.setText(Double.toString(temp));
                    break;
                case 't':
                    temp = Double.parseDouble(display.getText());
                    if (trig == 1) {
                        temp = Math.toRadians(temp);
                    }
                    temp = Math.tan(temp);
                    display.setText(Double.toString(temp));
                    break;
                case 'S':
                    temp = Double.parseDouble(display.getText());
                    if (trig == 1) {
                        temp = Math.toRadians(temp);
                    }
                    temp = Math.sinh(temp);
                    display.setText(Double.toString(temp));
                    break;
                case 'C':
                    temp = Double.parseDouble(display.getText());
                    if (trig == 1) {
                        temp = Math.toRadians(temp);
                    }
                    temp = Math.cosh(temp);
                    display.setText(Double.toString(temp));
                    break;
                case 'T':
                    temp = Double.parseDouble(display.getText());
                    if (trig == 1) {
                        temp = Math.toRadians(temp);
                    }
                    temp = Math.tanh(temp);
                    display.setText(Double.toString(temp));
                    break;
                case 'v':
                    temp = Double.parseDouble(display.getText());
                    if (temp < 0) {
                        display.setBackground(Color.red);
                        return;
                    }
                    temp = Math.sqrt(temp);
                    display.setText(Double.toString(temp));
                    break;
                case '!':
                    temp = Double.parseDouble(display.getText());
                    temp = fact(temp);
                    display.setText(Double.toString(temp));
                    break;
                case 'p':
                    display.setText(Double.toString(Math.PI));
                    break;

            }
            if (display.getText().indexOf(".") == -1) {
                point = false;
            } else {
                point = true;
            }
        } catch (Exception e) {
            play(-1);
        }
        setFocusable(true);
    }

    // </editor-fold>
    
    public CalcForm() {
        initComponents();
        setTitle("Sam As End Calc");
        setLocationRelativeTo(null);
        setFocusable(true);
        dateNtime = date;
    }

    //<editor-fold defaultstate="collapsed" desc="player">
    void play(int code) {
        switch (code) {
            case 0:
                play("audio/0.au");
                break;
            case 1:
                play("audio/1.au");
                break;
            case 2:
                play("audio/2.au");
                break;
            case 3:
                play("audio/3.au");
                break;
            case 4:
                play("audio/4.au");
                break;
            case 5:
                play("audio/5.au");
                break;
            case 6:
                play("audio/6.au");
                break;
            case 7:
                play("audio/7.au");
                break;
            case 8:
                play("audio/8.au");
                break;
            case 9:
                play("audio/9.au");
                break;
            case 10:
                play("audio/drip.au");
                break;
            case -1:
                play("audio/error.wav");
                break;
        }
    }

    void play(String s) {
        InputStream is = getClass().getResourceAsStream(s);
        AudioPlayer.player.start(is);
    }
    //</editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JLabel();
        mainPanal = new javax.swing.JPanel();
        display = new javax.swing.JTextField();
        btnPanal = new java.awt.Panel();
        std_calc = new javax.swing.JPanel();
        btn9 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btnpoint = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        btnpn = new javax.swing.JButton();
        op_add = new javax.swing.JButton();
        op_sub = new javax.swing.JButton();
        op_mul = new javax.swing.JButton();
        op_div = new javax.swing.JButton();
        op_mod = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        op_equal = new javax.swing.JButton();
        sci_calc = new javax.swing.JPanel();
        op_x2 = new javax.swing.JButton();
        op_x3 = new javax.swing.JButton();
        op_xy = new javax.swing.JButton();
        op_log = new javax.swing.JButton();
        op_sqrt = new javax.swing.JButton();
        op_pi = new javax.swing.JButton();
        op_n = new javax.swing.JButton();
        op_exp = new javax.swing.JButton();
        op_int = new javax.swing.JButton();
        op_sin = new javax.swing.JButton();
        op_cos = new javax.swing.JButton();
        op_tan = new javax.swing.JButton();
        op_1x = new javax.swing.JButton();
        op_sinh = new javax.swing.JButton();
        op_cosh = new javax.swing.JButton();
        op_tanh = new javax.swing.JButton();
        op_ln = new javax.swing.JButton();
        op_e = new javax.swing.JButton();
        op_trig = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        type = new javax.swing.JMenu();
        std = new javax.swing.JMenuItem();
        sci = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        helpTab = new javax.swing.JMenu();
        help = new javax.swing.JMenuItem();
        about = new javax.swing.JMenuItem();
        date = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                key(evt);
            }
        });

        header.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        header.setForeground(new java.awt.Color(131, 0, 0));
        header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.setLabelFor(header);
        header.setText("Sam As End Calculator");
        header.setToolTipText("Java SE");

        display.setEditable(false);
        display.setBackground(new java.awt.Color(255, 255, 255));
        display.setFont(new java.awt.Font("LCD", 1, 24));
        display.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        display.setToolTipText("");
        display.setAutoscrolls(false);
        display.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        display.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnPanal.setName(""); // NOI18N

        std_calc.setBackground(new java.awt.Color(255, 255, 255));

        btn9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btn8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn7.setText("7");
        btn7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btnpoint.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnpoint.setText(".");
        btnpoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpointActionPerformed(evt);
            }
        });

        btn0.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });

        btnpn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnpn.setText("+/-");
        btnpn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpnActionPerformed(evt);
            }
        });

        op_add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        op_add.setText("+");
        op_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_addActionPerformed(evt);
            }
        });

        op_sub.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        op_sub.setText("-");
        op_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_subActionPerformed(evt);
            }
        });

        op_mul.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        op_mul.setText("x");
        op_mul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_mulActionPerformed(evt);
            }
        });

        op_div.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        op_div.setText("÷");
        op_div.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_divActionPerformed(evt);
            }
        });

        op_mod.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        op_mod.setText("%");
        op_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_modActionPerformed(evt);
            }
        });

        btn_clear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_clear.setText("C");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        op_equal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        op_equal.setText("=");
        op_equal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_equalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout std_calcLayout = new javax.swing.GroupLayout(std_calc);
        std_calc.setLayout(std_calcLayout);
        std_calcLayout.setHorizontalGroup(
            std_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(std_calcLayout.createSequentialGroup()
                .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(op_sub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(std_calcLayout.createSequentialGroup()
                .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(op_mul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(std_calcLayout.createSequentialGroup()
                .addComponent(btnpn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn0, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnpoint, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(op_div, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(std_calcLayout.createSequentialGroup()
                .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(op_add, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(std_calcLayout.createSequentialGroup()
                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(op_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(op_equal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        std_calcLayout.setVerticalGroup(
            std_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(std_calcLayout.createSequentialGroup()
                .addGroup(std_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn7)
                    .addComponent(btn8)
                    .addComponent(btn9)
                    .addComponent(op_add))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(std_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn4)
                    .addComponent(btn5)
                    .addComponent(btn6)
                    .addComponent(op_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(std_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(std_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn2)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, std_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn3)
                            .addComponent(op_mul)))
                    .addComponent(btn1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(std_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnpn)
                    .addComponent(btn0)
                    .addComponent(btnpoint)
                    .addComponent(op_div))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(std_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(op_mod)
                    .addComponent(op_equal)
                    .addComponent(btn_clear)))
        );

        btn7.getAccessibleContext().setAccessibleName("");

        sci_calc.setBackground(new java.awt.Color(255, 255, 255));

        op_x2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        op_x2.setText("<html>X<sup>2</sup>");
        op_x2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_x2ActionPerformed(evt);
            }
        });

        op_x3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        op_x3.setText("<html>X<sup>3</sup>");
        op_x3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_x3ActionPerformed(evt);
            }
        });

        op_xy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        op_xy.setText("<html>x<sup>y</sup>");
        op_xy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_xyActionPerformed(evt);
            }
        });

        op_log.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        op_log.setText("log");
        op_log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_logActionPerformed(evt);
            }
        });

        op_sqrt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        op_sqrt.setText("√x");
        op_sqrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_sqrtActionPerformed(evt);
            }
        });

        op_pi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        op_pi.setText("∏");
        op_pi.setActionCommand("<html><sup>3</sup>√X");
        op_pi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_piActionPerformed(evt);
            }
        });

        op_n.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        op_n.setText("n!");
        op_n.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_nActionPerformed(evt);
            }
        });

        op_exp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        op_exp.setText("<html>10<sup>x</sup>");
        op_exp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_expActionPerformed(evt);
            }
        });

        op_int.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        op_int.setText("int()");
        op_int.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_intActionPerformed(evt);
            }
        });

        op_sin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        op_sin.setText("sin");
        op_sin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_sinActionPerformed(evt);
            }
        });

        op_cos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        op_cos.setText("cos");
        op_cos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_cosActionPerformed(evt);
            }
        });

        op_tan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        op_tan.setText("tan");
        op_tan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_tanActionPerformed(evt);
            }
        });

        op_1x.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        op_1x.setText("1/x");
        op_1x.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_1xActionPerformed(evt);
            }
        });

        op_sinh.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        op_sinh.setText("sinh");
        op_sinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_sinhActionPerformed(evt);
            }
        });

        op_cosh.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        op_cosh.setText("cosh");
        op_cosh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_coshActionPerformed(evt);
            }
        });

        op_tanh.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        op_tanh.setText("tanh");
        op_tanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_tanhActionPerformed(evt);
            }
        });

        op_ln.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        op_ln.setText("ln");
        op_ln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_lnActionPerformed(evt);
            }
        });

        op_e.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        op_e.setText("e");
        op_e.setToolTipText("");
        op_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_eActionPerformed(evt);
            }
        });

        op_trig.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        op_trig.setText(trig());
        op_trig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_trigActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Lucida Console", 0, 24)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 0, 0));
        reset.setText("R");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sci_calcLayout = new javax.swing.GroupLayout(sci_calc);
        sci_calc.setLayout(sci_calcLayout);
        sci_calcLayout.setHorizontalGroup(
            sci_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sci_calcLayout.createSequentialGroup()
                .addComponent(op_ln, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(op_e, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(op_trig, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sci_calcLayout.createSequentialGroup()
                .addGroup(sci_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sci_calcLayout.createSequentialGroup()
                        .addComponent(op_xy, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(op_n, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(op_cos, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sci_calcLayout.createSequentialGroup()
                        .addGroup(sci_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sci_calcLayout.createSequentialGroup()
                                .addComponent(op_x2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(op_sqrt, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(sci_calcLayout.createSequentialGroup()
                                .addComponent(op_x3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(op_pi, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sci_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(op_int)
                            .addComponent(op_sin, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(sci_calcLayout.createSequentialGroup()
                        .addComponent(op_log, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(op_exp, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(op_tan, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sci_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(op_cosh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(op_tanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(op_sinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(op_1x, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        sci_calcLayout.setVerticalGroup(
            sci_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sci_calcLayout.createSequentialGroup()
                .addGroup(sci_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(sci_calcLayout.createSequentialGroup()
                        .addGroup(sci_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(op_x2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(sci_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(op_sqrt)
                                .addComponent(op_int)
                                .addComponent(op_1x)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(sci_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(op_x3)
                            .addComponent(op_pi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(sci_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(op_sin)
                        .addComponent(op_sinh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sci_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(op_xy, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(op_cos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(op_cosh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(op_n, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sci_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(op_tan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(op_tanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(op_exp)
                    .addComponent(op_log, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(sci_calcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(op_trig, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(op_e, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(op_ln, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout btnPanalLayout = new javax.swing.GroupLayout(btnPanal);
        btnPanal.setLayout(btnPanalLayout);
        btnPanalLayout.setHorizontalGroup(
            btnPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(std_calc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sci_calc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnPanalLayout.setVerticalGroup(
            btnPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnPanalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(std_calc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sci_calc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanalLayout = new javax.swing.GroupLayout(mainPanal);
        mainPanal.setLayout(mainPanalLayout);
        mainPanalLayout.setHorizontalGroup(
            mainPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(display)
            .addGroup(mainPanalLayout.createSequentialGroup()
                .addComponent(btnPanal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        mainPanalLayout.setVerticalGroup(
            mainPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanalLayout.createSequentialGroup()
                .addComponent(display, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPanal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(248, 248, 248))
        );

        type.setText("Type");

        std.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        std.setBackground(new java.awt.Color(255, 255, 255));
        std.setText("Standard");
        std.setIconTextGap(0);
        std.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdActionPerformed(evt);
            }
        });
        type.add(std);

        sci.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        sci.setBackground(new java.awt.Color(255, 255, 255));
        sci.setText("Scintific");
        sci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sciActionPerformed(evt);
            }
        });
        type.add(sci);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        type.add(jMenuItem1);

        menu.add(type);

        helpTab.setText("Help");

        help.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/help.png"))); // NOI18N
        help.setText("Help");
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        helpTab.add(help);

        about.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_MASK));
        about.setText("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        helpTab.add(about);

        menu.add(helpTab);

        date.setBorder(null);
        date.setForeground(new java.awt.Color(4, 128, 0));
        date.setText("                                                                   ");
        date.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        date.setDelay(9999);
        date.setEnabled(false);
        menu.add(date);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                        .addGap(211, 211, 211))
                    .addComponent(mainPanal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainPanal, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Number code">
    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        if (cheak()) {
            return;
        }
        play(7);
        display.setText(display.getText() + "7");
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        if (cheak()) {
            return;
        }
        play(8);
        display.setText(display.getText() + "8");
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        if (cheak()) {
            return;
        }
        play(9);
        display.setText(display.getText() + "9");
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        if (cheak()) {
            return;
        }
        play(4);
        display.setText(display.getText() + "4");
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        if (cheak()) {
            return;
        }
        play(5);
        display.setText(display.getText() + "5");
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        // TODO add your handling code here:
        if (cheak()) {
            return;
        }
        play(6);
        display.setText(display.getText() + "6");
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        if (cheak()) {
            return;
        }
        play(1);
        display.setText(display.getText() + "1");
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
        if (cheak()) {
            return;
        }
        play(2);
        display.setText(display.getText() + "2");
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
        if (cheak()) {
            return;
        }
        play(3);
        display.setText(display.getText() + "3");
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        // TODO add your handling code here:
        if (cheak()) {
            return;
        }
        play(0);
        display.setText(display.getText() + "0");
    }//GEN-LAST:event_btn0ActionPerformed

    private void btnpointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpointActionPerformed
        // TODO add your handling code here:
        if (cheak()) {
            return;
        }
        if (!point) {
            if ("".equals(display.getText())) {
                display.setText("0.");
            } else {
                display.setText(display.getText() + ".");
            }
            point = true;
        }
        else {
            play(-1);
        }
    }//GEN-LAST:event_btnpointActionPerformed
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Event Handeler">
    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        cheak();
        point = false;
        display.setText(null);
    }//GEN-LAST:event_btn_clearActionPerformed

    private void stdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdActionPerformed
        // TODO add your handling code here:
        sci_calc.setVisible(false);
        this.setSize(375, 350);
    }//GEN-LAST:event_stdActionPerformed

    private void sciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sciActionPerformed
        // TODO add your handling code here:
        sci_calc.setVisible(true);
        this.setSize(695, 350);
    }//GEN-LAST:event_sciActionPerformed

    private void op_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_addActionPerformed
        // TODO add your handling code here:
        if (answering) {
            return;
        }
        op(op);
        op = '+';
        display.setText("" + Double.toString(ans) + "");
        answering = true;
    }//GEN-LAST:event_op_addActionPerformed

    private void op_subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_subActionPerformed
        // TODO add your handling code here:
        if (answering) {
            return;
        }
        op(op);
        op = '-';
        display.setText("" + Double.toString(ans) + "");
        answering = true;
    }//GEN-LAST:event_op_subActionPerformed

    private void op_mulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_mulActionPerformed
        // TODO add your handling code here:
        if (answering) {
            return;
        }
        op(op);
        op = '*';
        display.setText("" + Double.toString(ans) + "");
        answering = true;
    }//GEN-LAST:event_op_mulActionPerformed

    private void op_divActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_divActionPerformed
        // TODO add your handling code here:
        if (answering) {
            return;
        }
        op(op);
        op = '/';
        display.setText("" + Double.toString(ans) + "");
        answering = true;
    }//GEN-LAST:event_op_divActionPerformed

    private void op_equalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_equalActionPerformed
        // TODO add your handling code here:
        if (answering) {
            op = ' ';
        } else {
            op(op);
        }
        play(10);
        display.setText("" + Double.toString(ans) + "");
        answering = true;
    }//GEN-LAST:event_op_equalActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        op = ' ';
        ans = 0;
        point = false;
        answering = false;
        display.setText("");
        display.setBackground(Color.white);
    }//GEN-LAST:event_resetActionPerformed

    private void op_x2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_x2ActionPerformed
        // TODO add your handling code here:
        op('2');
    }//GEN-LAST:event_op_x2ActionPerformed

    private void op_trigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_trigActionPerformed
        // TODO add your handling code here:
        if (trig == 0) {
            trig = 1;
        } else {
            trig = 0;
        }
        op_trig.setText(trig());
    }//GEN-LAST:event_op_trigActionPerformed

    private void btnpnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpnActionPerformed
        // TODO add your handling code here:
        double inverter;
        inverter = Double.parseDouble(display.getText());
        inverter *= -1;
        display.setText(Double.toString(inverter));
    }//GEN-LAST:event_btnpnActionPerformed

    private void op_x3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_x3ActionPerformed
        // TODO add your handling code here:
        op('3');
    }//GEN-LAST:event_op_x3ActionPerformed

    private void op_xyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_xyActionPerformed
        // TODO add your handling code here:
        if (answering) {
            return;
        }
        op(op);
        op = '^';
        display.setText("" + Double.toString(ans) + "");
        answering = true;
    }//GEN-LAST:event_op_xyActionPerformed

    private void op_logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_logActionPerformed
        // TODO add your handling code here:
        op('l');
    }//GEN-LAST:event_op_logActionPerformed

    private void op_eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_eActionPerformed
        // TODO add your handling code here:
        op('e');
    }//GEN-LAST:event_op_eActionPerformed

    private void op_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_modActionPerformed
        // TODO add your handling code here:
        if (answering) {
            return;
        }
        op(op);
        op = '%';
        display.setText("" + Double.toString(ans) + "");
        answering = true;
    }//GEN-LAST:event_op_modActionPerformed

    private void op_lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_lnActionPerformed
        // TODO add your handling code here:
        op('n');
    }//GEN-LAST:event_op_lnActionPerformed

    private void op_expActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_expActionPerformed
        // TODO add your handling code here:
        op('x');
    }//GEN-LAST:event_op_expActionPerformed

    private void op_intActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_intActionPerformed
        op('i');
    }//GEN-LAST:event_op_intActionPerformed

    private void op_1xActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_1xActionPerformed
        op(',');
    }//GEN-LAST:event_op_1xActionPerformed

    private void op_sinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_sinActionPerformed
        op('s');
    }//GEN-LAST:event_op_sinActionPerformed

    private void op_cosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_cosActionPerformed
        op('c');
    }//GEN-LAST:event_op_cosActionPerformed

    private void op_tanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_tanActionPerformed
        op('t');
    }//GEN-LAST:event_op_tanActionPerformed

    private void op_sinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_sinhActionPerformed
        op('S');
    }//GEN-LAST:event_op_sinhActionPerformed

    private void op_coshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_coshActionPerformed
        op('C');
    }//GEN-LAST:event_op_coshActionPerformed

    private void op_tanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_tanhActionPerformed
        op('T');
    }//GEN-LAST:event_op_tanhActionPerformed

    private void op_sqrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_sqrtActionPerformed
        op('v');
    }//GEN-LAST:event_op_sqrtActionPerformed

    private void op_piActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_piActionPerformed
        op('p');
    }//GEN-LAST:event_op_piActionPerformed

    private void op_nActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_nActionPerformed
        op('!');
    }//GEN-LAST:event_op_nActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        JPanel parent = new JPanel();
        JLabel imgLabel = new JLabel();
        JLabel txt = new JLabel();
        imgLabel.setIcon(new ImageIcon(getClass().getResource("/img/SamAsEnd.png")));
        imgLabel.setVerticalAlignment(SwingConstants.CENTER);
        txt.setText("<html><center>"
                + "<h1>Help</h1><br />"
                + "Sorry i don't have a <br />"
                + "help content for now!!!</center>");
        parent.setLayout(new BorderLayout());
        parent.add(imgLabel, BorderLayout.NORTH);
        parent.add(txt, BorderLayout.SOUTH);
        String s[] = {"Close"};
        JOptionPane.showOptionDialog(this, parent, "Sam As End", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, s, s[0]);
    }//GEN-LAST:event_helpActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        JPanel parent = new JPanel();
        JLabel imgLabel = new JLabel();
        JLabel txt = new JLabel();
        imgLabel.setIcon(new ImageIcon(getClass().getResource("/img/SamAsEnd.png")));
        imgLabel.setVerticalAlignment(SwingConstants.CENTER);
        txt.setText("<html><center>"
                + "<h2>GNU GENERAL PUBLIC LICENSE</h2><br />\n"
                + "Version 2, June 1991<br />"
                + "\n   Copyright (C) 1989, 1991 Free Software <br />"
                + "\nFoundation, Inc., 51 Franklin Street, <br />"
                + "\nFifth Floor, Boston, MA 02110-1301 USA <br />"
                + "\nEveryone is permitted to copy and distribute <br />"
                + "verbatim copies of this license document, but<br />"
                + " changing it is not allowed.<br />"
                + "\n Preamble<br />\n 2013<br />"
                + "1st V (11/3/2013)<br />"
                + "2nd V (27/9/2013)"
                + "</center>");
        parent.setLayout(new BorderLayout());
        parent.add(imgLabel, BorderLayout.NORTH);
        parent.add(txt, BorderLayout.SOUTH);
        String s[] = {"Close"};
        JOptionPane.showOptionDialog(this, parent, "Sam As End", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, s, s[0]);
    }//GEN-LAST:event_aboutActionPerformed

    private void key(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_key
        int keyInt = evt.getKeyCode();
        int keyChar = evt.getKeyChar();
        if (keyChar == '0') {
            btn0ActionPerformed(null);
        } else if (keyChar == '1') {
            btn1ActionPerformed(null);
        } else if (keyChar == '2') {
            btn2ActionPerformed(null);
        } else if (keyChar == '3') {
            btn3ActionPerformed(null);
        } else if (keyChar == '4') {
            btn4ActionPerformed(null);
        } else if (keyChar == '5') {
            btn5ActionPerformed(null);
        } else if (keyChar == '6') {
            btn6ActionPerformed(null);
        } else if (keyChar == '6') {
            btn6ActionPerformed(null);
        } else if (keyChar == '7') {
            btn7ActionPerformed(null);
        } else if (keyChar == '8') {
            btn8ActionPerformed(null);
        } else if (keyChar == '9') {
            btn9ActionPerformed(null);
        } else if (keyInt == KeyEvent.VK_ADD) {
            op_addActionPerformed(null);
        } else if (keyInt == KeyEvent.VK_SUBTRACT) {
            op_subActionPerformed(null);
        } else if (keyInt == KeyEvent.VK_MULTIPLY) {
            op_mulActionPerformed(null);
        } else if (keyInt == KeyEvent.VK_DIVIDE) {
            op_divActionPerformed(null);
        } else if (keyInt == KeyEvent.VK_PERIOD) {
            btnpointActionPerformed(null);
        } else if (keyInt == KeyEvent.VK_R) {
            resetActionPerformed(null);
        } else if (keyInt == KeyEvent.VK_EQUALS || keyInt == KeyEvent.VK_ENTER) {
            op_equalActionPerformed(null);
        } else {
            System.out.println(evt);
        }
    }//GEN-LAST:event_key

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    // </editor-fold>

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Jframe init">
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalcForm().setVisible(true);
            }
        });

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CalcForm.startDateTime();
            }
        });
        //</editor-fold>

    }
    
    // <editor-fold defaultstate="collapsed" desc=" Variables declaration ">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    public javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private java.awt.Panel btnPanal;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btnpn;
    private javax.swing.JButton btnpoint;
    private javax.swing.JMenu date;
    public static javax.swing.JTextField display;
    private javax.swing.JLabel header;
    private javax.swing.JMenuItem help;
    private javax.swing.JMenu helpTab;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel mainPanal;
    private javax.swing.JMenuBar menu;
    private javax.swing.JButton op_1x;
    private javax.swing.JButton op_add;
    private javax.swing.JButton op_cos;
    private javax.swing.JButton op_cosh;
    private javax.swing.JButton op_div;
    private javax.swing.JButton op_e;
    private javax.swing.JButton op_equal;
    private javax.swing.JButton op_exp;
    private javax.swing.JButton op_int;
    private javax.swing.JButton op_ln;
    private javax.swing.JButton op_log;
    private javax.swing.JButton op_mod;
    private javax.swing.JButton op_mul;
    private javax.swing.JButton op_n;
    private javax.swing.JButton op_pi;
    private javax.swing.JButton op_sin;
    private javax.swing.JButton op_sinh;
    private javax.swing.JButton op_sqrt;
    private javax.swing.JButton op_sub;
    private javax.swing.JButton op_tan;
    private javax.swing.JButton op_tanh;
    private javax.swing.JButton op_trig;
    private javax.swing.JButton op_x2;
    private javax.swing.JButton op_x3;
    private javax.swing.JButton op_xy;
    private javax.swing.JButton reset;
    private javax.swing.JMenuItem sci;
    private javax.swing.JPanel sci_calc;
    private javax.swing.JMenuItem std;
    private javax.swing.JPanel std_calc;
    private javax.swing.JMenu type;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}