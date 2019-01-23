package com.mygdx.game;

import com.mygdx.game.commands.*;

//controller for user
public class CharacterCommandControler {
    private Command q;
    private Command w;
    private Command e;
    private Command r;
    private Command t;
    private Command y;
    private Command u;
    private Command i;
    private Command o;
    private Command p;
    private Command a;
    private Command s;
    private Command d;
    private Command f;
    private Command g;
    private Command h;
    private Command j;
    private Command k;
    private Command l;
    private Command z;
    private Command x;
    private Command c;
    private Command v;
    private Command b;
    private Command n;
    private Command m;
    private Command n1;
    private Command n2;
    private Command n3;
    private Command n4;
    private Command n5;
    private Command n6;
    private Command n7;
    private Command n8;
    private Command n9;
    private Command n0;
    private Command shift;
    private Command enter;
    private Command ctrl;
    private Command leftArrow;
    private Command rightArrow;
    private Command upArrow;
    private Command downArrow;
    private Command tilda;

    public void loadSettings(){
        setW(AllCommands.UP.theCommand);
        setA(AllCommands.LEFT.theCommand);
        setS(AllCommands.DOWN.theCommand);
        setD(AllCommands.RIGHT.theCommand);
    }

    public void setQ(Command q) {
        this.q = q;
    }

    public void pressQ(GameCharacter entity){
        q.pressed(entity);
    }

    public void releaseQ(GameCharacter entity){
        q.released(entity);
    }

    public void setW(Command w) {
        this.w = w;
    }

    public void pressW(GameCharacter entity){
        w.pressed(entity);
    }

    public void releasedW(GameCharacter entity){
        w.released(entity);
    }

    public void setE(Command e) {
        this.e = e;
    }

    public void pressE(GameCharacter entity){
        e.pressed(entity);
    }

    public void releasedE(GameCharacter entity){
        e.released(entity);
    }

    public void setR(Command r) {
        this.r = r;
    }

    public void pressR(GameCharacter entity){
        r.pressed(entity);
    }

    public void releasedR(GameCharacter entity){
        r.released(entity);
    }

    public void setT(Command t) {
        this.t = t;
    }

    public void pressT(GameCharacter entity){
        t.pressed(entity);
    }

    public void releasedT(GameCharacter entity){
        t.released(entity);
    }

    public void setY(Command y) {
        this.y = y;
    }

    public void pressY(GameCharacter entity){
        y.pressed(entity);
    }

    public void releasedY(GameCharacter entity){
        y.released(entity);
    }

    public void setU(Command u) {
        this.u = u;
    }

    public void pressU(GameCharacter entity){
        u.pressed(entity);
    }

    public void releasedU(GameCharacter entity){
        u.released(entity);
    }

    public void setI(Command i) {
        this.i = i;
    }

    public void pressI(GameCharacter entity){
        i.pressed(entity);
    }

    public void releasedI(GameCharacter entity){
        i.released(entity);
    }

    public void setO(Command o) {
        this.o = o;
    }

    public void pressO(GameCharacter entity){
        o.pressed(entity);
    }

    public void releasedO(GameCharacter entity){
        o.released(entity);
    }

    public void setP(Command p) {
        this.p = p;
    }

    public void pressP(GameCharacter entity){
        p.pressed(entity);
    }

    public void releasedP(GameCharacter entity){
        p.released(entity);
    }

    public void setA(Command a) {
        this.a = a;
    }

    public void pressA(GameCharacter entity){
        a.pressed(entity);
    }

    public void releasedA(GameCharacter entity){
        a.released(entity);
    }

    public void setS(Command s) {
        this.s = s;
    }

    public void pressS(GameCharacter entity){
        s.pressed(entity);
    }

    public void releasedS(GameCharacter entity){
        s.released(entity);
    }

    public void setD(Command d) {
        this.d = d;
    }

    public void pressD(GameCharacter entity){
        d.pressed(entity);
    }

    public void releasedD(GameCharacter entity){
        d.released(entity);
    }

    public void setF(Command f) {
        this.f = f;
    }

    public void pressF(GameCharacter entity){
        f.pressed(entity);
    }

    public void releasedF(GameCharacter entity){
        f.released(entity);
    }

    public void setG(Command g) {
        this.g = g;
    }

    public void pressG(GameCharacter entity){
        g.pressed(entity);
    }

    public void releasedG(GameCharacter entity){
        g.released(entity);
    }

    public void setH(Command h) {
        this.h = h;
    }

    public void pressH(GameCharacter entity){
        h.pressed(entity);
    }

    public void releasedH(GameCharacter entity){
        h.released(entity);
    }

    public void setJ(Command j) {
        this.j = j;
    }

    public void pressJ(GameCharacter entity){
        j.pressed(entity);
    }

    public void releasedJ(GameCharacter entity){
        j.released(entity);
    }

    public void setK(Command k) {
        this.k = k;
    }

    public void pressK(GameCharacter entity){
        k.pressed(entity);
    }

    public void releasedK(GameCharacter entity){
        k.released(entity);
    }

    public void setL(Command l) {
        this.l = l;
    }

    public void pressL(GameCharacter entity){
        l.pressed(entity);
    }

    public void releasedL(GameCharacter entity){
        l.released(entity);
    }

    public void setZ(Command z) {
        this.z = z;
    }

    public void pressZ(GameCharacter entity){
        z.pressed(entity);
    }

    public void releasedZ(GameCharacter entity){
        z.released(entity);
    }

    public void setX(Command x) {
        this.x = x;
    }

    public void pressX(GameCharacter entity){
        x.pressed(entity);
    }

    public void releasedX(GameCharacter entity){
        x.released(entity);
    }

    public void setC(Command c) {
        this.c = c;
    }

    public void pressC(GameCharacter entity){
        c.pressed(entity);
    }

    public void releasedC(GameCharacter entity){
        c.released(entity);
    }

    public void setV(Command v) {
        this.v = v;
    }

    public void pressV(GameCharacter entity){
        v.pressed(entity);
    }

    public void releasedV(GameCharacter entity){
        v.released(entity);
    }

    public void setB(Command b) {
        this.b = b;
    }

    public void pressB(GameCharacter entity){
        b.pressed(entity);
    }

    public void releasedB(GameCharacter entity){
        b.released(entity);
    }

    public void setN(Command n) {
        this.n = n;
    }

    public void pressN(GameCharacter entity){
        n.pressed(entity);
    }

    public void releasedN(GameCharacter entity){
        n.released(entity);
    }

    public void setM(Command m) {
        this.m = m;
    }

    public void pressM(GameCharacter entity){
        m.pressed(entity);
    }

    public void releasedM(GameCharacter entity){
        m.released(entity);
    }

    public void setN1(Command n1) {
        this.n1 = n1;
    }

    public void pressN1(GameCharacter entity){
        n1.pressed(entity);
    }

    public void releasedN1(GameCharacter entity){
        n1.released(entity);
    }

    public void setN2(Command n2) {
        this.n2 = n2;
    }

    public void pressN2(GameCharacter entity){
        n2.pressed(entity);
    }

    public void releasedN2(GameCharacter entity){
        n2.released(entity);
    }

    public void setN3(Command n3) {
        this.n3 = n3;
    }

    public void pressN3(GameCharacter entity){
        n3.pressed(entity);
    }

    public void releasedN3(GameCharacter entity){
        n3.released(entity);
    }

    public void setN4(Command n4) {
        this.n4 = n4;
    }

    public void pressN4(GameCharacter entity){
        n4.pressed(entity);
    }

    public void releasedN4(GameCharacter entity){
        n4.released(entity);
    }

    public void setN5(Command n5) {
        this.n5 = n5;
    }

    public void pressN5(GameCharacter entity){
        n5.pressed(entity);
    }

    public void releasedN5(GameCharacter entity){
        n5.released(entity);
    }

    public void setN6(Command n6) {
        this.n6 = n6;
    }

    public void pressN6(GameCharacter entity){
        n6.pressed(entity);
    }

    public void releasedN6(GameCharacter entity){
        n6.released(entity);
    }

    public void setN7(Command n7) {
        this.n7 = n7;
    }

    public void pressN7(GameCharacter entity){
        n7.pressed(entity);
    }

    public void releasedN7(GameCharacter entity){
        n7.released(entity);
    }

    public void setN8(Command n8) {
        this.n8 = n8;
    }
    public void pressN8(GameCharacter entity){
        n8.pressed(entity);
    }

    public void releasedN8(GameCharacter entity){
        n8.released(entity);
    }

    public void setN9(Command n9) {
        this.n9 = n9;
    }

    public void pressN9(GameCharacter entity){
        n9.pressed(entity);
    }

    public void releasedN9(GameCharacter entity){
        n9.released(entity);
    }

    public void setN0(Command n0) {
        this.n0 = n0;
    }

    public void pressN0(GameCharacter entity){
        n0.pressed(entity);
    }

    public void releasedN0(GameCharacter entity){
        n0.released(entity);
    }

    public void setShift(Command shift) {
        this.shift = shift;
    }

    public void pressShift(GameCharacter entity){
        shift.pressed(entity);
    }

    public void releasedShift(GameCharacter entity){
        shift.released(entity);
    }

    public void setEnter(Command enter) {
        this.enter = enter;
    }

    public void pressEnter(GameCharacter entity){
        enter.pressed(entity);
    }

    public void releasedEnter(GameCharacter entity){
        enter.released(entity);
    }

    public void setCtrl(Command ctrl) {
        this.ctrl = ctrl;
    }

    public void pressCtrl(GameCharacter entity){
        ctrl.pressed(entity);
    }

    public void releasedCtrl(GameCharacter entity){
        ctrl.released(entity);
    }

    public void setLeftArrow(Command leftArrow) {
        this.leftArrow = leftArrow;
    }

    public void pressLeftArrow(GameCharacter entity){
        leftArrow.pressed(entity);
    }

    public void releasedLeftArrow(GameCharacter entity){
        leftArrow.released(entity);
    }

    public void setRightArrow(Command rightArrow) {
        this.rightArrow = rightArrow;
    }

    public void pressRightArrow(GameCharacter entity){
        rightArrow.pressed(entity);
    }

    public void releasedRightArrow(GameCharacter entity){
        rightArrow.released(entity);
    }

    public void setUpArrow(Command upArrow) {
        this.upArrow = upArrow;
    }

    public void pressUpArrow(GameCharacter entity){
        upArrow.pressed(entity);
    }

    public void releasedUpArrow(GameCharacter entity){
        upArrow.pressed(entity);
    }

    public void setDownArrow(Command downArrow) {
        this.downArrow = downArrow;
    }

    public void pressDownArrow(GameCharacter entity){
        downArrow.pressed(entity);
    }

    public void releasedDownArrow(GameCharacter entity){
        downArrow.released(entity);
    }

    public void setTilda(Command tilda) {
        this.tilda = tilda;
    }

    public void pressTilda(GameCharacter entity){
        tilda.pressed(entity);
    }

    public void releasedTilda(GameCharacter entity){
        tilda.released(entity);
    }
}
