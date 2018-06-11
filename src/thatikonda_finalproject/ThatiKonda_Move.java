/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thatikonda_finalproject;

/**
 *
 * @author ThatiKonda
 */
class ThatiKonda_Move {

    ThatiKonda_FinalProject Animal;
    private boolean boolLck = false;

    ThatiKonda_Move(ThatiKonda_FinalProject A1) {
        Animal = A1;
    }

    void moveObject(int x, int T) {
        switch (T) {
            case 1:
                MoveTurtle(x);
                break;
            case 2:
                MoveRabbit(x);
                break;
        }
    }

    private synchronized void MoveTurtle(int x) {
        Turtle_Begin();
        GO(x);
        Turtle_End();
    }

    private synchronized void MoveRabbit(int x) {
        Rabbit_Begin();
        GO(x);
        Rabbit_End();
    }

    private void GO(int x) {
        int TurtlePt = 0;
        int RabbitPt = 0;

        while (TurtlePt <= 500 || RabbitPt <= 500) {
            double RVal = Math.random();

            if (RVal >= 0) {

                if (RVal < 0.5) {
                    TurtlePt = TurtlePt + 20;
                    Animal.showMessagelb.setText("Moving Turtle 2 Positions to the right");

                } else if (RVal < 0.7) {
                    TurtlePt = TurtlePt - 40;
                    if (TurtlePt <= 0) {
                        TurtlePt = 0;
                    }
                    Animal.showMessagelb.setText("Moving Turtle 4 Positions to the left");

                } else {
                    TurtlePt = TurtlePt + 10;
                    Animal.showMessagelb.setText("Moving Turtle 1 Position to the right");
                }
                Animal.Walk(TurtlePt, 1);

                try {

                    Thread.sleep(130);

                } catch (Exception exp) {

                }
            }

            if (TurtlePt >= 500) {
                boolLck = false;
                notifyAll();
                Animal.showMessagelb.setText("Tortise is the Champion");

                break;
            }
            if (TurtlePt < 500 || RabbitPt < 500) {
                if (RVal < 0.2) {
                    RabbitPt = RabbitPt + 0;
                    Animal.showMessagelb.setText("Rabit Didnt Move");

                } else if (RVal < 0.4) {
                    RabbitPt = RabbitPt + 70;
                    Animal.showMessagelb.setText("Moving Rabbit 7 Positions to the right");

                } else if (RVal < 0.5) {
                    RabbitPt = RabbitPt - 100;
                    if (RabbitPt <= 0) {
                        RabbitPt = 0;
                    }
                    Animal.showMessagelb.setText("Moving Rabbit 10 Positions to the left");

                } else if (RVal < 0.8) {
                    RabbitPt = RabbitPt + 10;
                    Animal.showMessagelb.setText("Moving Rabbit 1 Position to the right");

                } else {
                    RabbitPt = RabbitPt - 20;
                    if (RabbitPt <= 0) {
                        RabbitPt = 0;
                    }
                    Animal.showMessagelb.setText("Moving Rabbit 2 Position to the left");
                }
                Animal.Walk(RabbitPt, 2);

                try {
                    Thread.sleep(130);
                } catch (Exception exp) {

                }
            }
            if (RabbitPt >= 500) {
                boolLck = false;
                notifyAll();
                Animal.showMessagelb.setText("Rabbit is the Champion");
                break;
            }

        }
    }

    public synchronized void Turtle_Begin() {
        while (boolLck) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception");

            }
            boolLck = true;
            notifyAll();

        }
    }

    public synchronized void Turtle_End() {
        boolLck = false;

        notifyAll();

    }

    public synchronized void Rabbit_Begin() {
        try {
            wait();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception");

        }
        boolLck = true;
        notifyAll();

    }

    public synchronized void Rabbit_End() {
        boolLck = false;
        notifyAll();

    }

}
