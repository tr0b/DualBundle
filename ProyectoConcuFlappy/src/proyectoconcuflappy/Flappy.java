/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoconcuflappy;

/**
 *
 * @author Josue Hernandez
 */
public class Flappy extends Thread {

    private int velocidad;
    private boolean saltar;
    private boolean detenerSalto1 = false;
    private boolean detenerSalto2 = true;
    private boolean jumping = false;
    private final Jugar parent;
    public static boolean detenethilo;

    public Flappy(Jugar parent) {
        this.velocidad = 10;
        this.parent = parent;
    }

    @Override
    public void run() {
        int varA = 1;
        detenethilo = false;
        while (true) {
            if (detenethilo) {
                break;
            }
            int x = Jugar.jFlappy.getLocation().x;
            if (!isSaltar()) {
                int y = Jugar.jFlappy.getLocation().y;
                try {
                    Thread.sleep(getVelocidad());
                    Jugar.jFlappy.setLocation(x, (y + 1));
                    if (velocidad > 3) {
                        if (varA % 15 == 0) {
                            velocidad = velocidad - 1;
                        }
                        varA = varA + 1;
                    }
                    parent.validarChoqueTubos();
                } catch (InterruptedException e) {
                    System.out.println("Ocurrio un problema " + e);
                }
            } else {
                if (!jumping) {
                    setDetenerSalto1(false);
                    setDetenerSalto2(true);
                    jumping = true;
                    jump1();
                } else {
                    setDetenerSalto1(true);
                    setDetenerSalto2(false);
                    jumping = false;
                    jump2();
                }
            }
            this.parent.ValidarChoque();
        }
    }

    private void jump1() {
        int tiempo_salto = 1;
        while (true) {
            int y = Jugar.jFlappy.getLocation().y;
            int x = Jugar.jFlappy.getLocation().x;
            try {
                Thread.sleep(getVelocidad());
                if (!isDetenerSalto1()) {
                    tiempo_salto = tiempo_salto + 1;
                    if (tiempo_salto <= 60) {
                        Jugar.jFlappy.setLocation(x, (y - 1));
                        if (tiempo_salto % 20 == 0) {
                            velocidad = velocidad - 1;
                        }
                    } else if (tiempo_salto >= 70) {
                        setSaltar(false);
                        setVelocidad(7);
                        break;
                    }
                    parent.validarChoqueTubos();
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                System.out.println("Ocurrio un error " + e);
            }
        }
    }

    private void jump2() {
        int tiempo_salto = 1;
        while (true) {
            int y = Jugar.jFlappy.getLocation().y;
            int x = Jugar.jFlappy.getLocation().x;
            try {
                Thread.sleep(getVelocidad());
                if (!isDetenerSalto2()) {
                    tiempo_salto = tiempo_salto + 1;
                    if (tiempo_salto <= 60) {
                        Jugar.jFlappy.setLocation(x, (y - 1));
                        if (tiempo_salto % 20 == 0) {
                            velocidad = velocidad - 1;
                        }
                    } else if (tiempo_salto >= 70) {
                        setSaltar(false);
                        setVelocidad(7);
                        break;
                    }
                    parent.validarChoqueTubos();
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                System.out.println("Ocurrio un error " + e);
            }
        }
    }

    public boolean isDetenerSalto1() {
        return detenerSalto1;
    }

    public void setDetenerSalto1(boolean detenerSalto1) {
        this.detenerSalto1 = detenerSalto1;
    }

    public boolean isDetenerSalto2() {
        return detenerSalto2;
    }

    public void setDetenerSalto2(boolean detenerSalto2) {
        this.detenerSalto2 = detenerSalto2;
    }

    public boolean isSaltar() {
        return saltar;
    }

    public void setSaltar(boolean saltar) {
        this.saltar = saltar;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public boolean isDetenethilo() {
        return detenethilo;
    }

}
