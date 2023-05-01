package io.hmshamim;


import io.hmshamim.adapter.AdapterSimulator;
import io.hmshamim.chainOfresponsibility.ChainOfResponsibilitySimulation;
import io.hmshamim.command.CommandSimulation;
import io.hmshamim.composite.SimulateComposite;
import io.hmshamim.iterator.IteratorSimulation;
import io.hmshamim.mediator.ArticleDialogBox;
import io.hmshamim.mediator.MediatorSimulation;
import io.hmshamim.momento.MomentoSimulation;
import io.hmshamim.observer.ObserverSimulation;
import io.hmshamim.observer.pullstyle.ObserverPullStyleSimulation;
import io.hmshamim.observer.pushstyle.ObserverPushStyleSimulation;
import io.hmshamim.state.StateSimulation;
import io.hmshamim.strategy.StrategySimulation;
import io.hmshamim.template.TemplateSimulation;
import io.hmshamim.visitor.SimulateVisitor;

public class Main {
    public static void main(String[] args) {
        System.out.println("Uncomment following line one by one to simulate of each Design Pattern.");
/*
        MomentoSimulation.simulate();
        StateSimulation.simulate();
        IteratorSimulation.simulate();
        StrategySimulation.simulate();
        TemplateSimulation.simulate();
        CommandSimulation.simulate();
        ObserverSimulation.simulate();
        ObserverPushStyleSimulation.simulate();
        ObserverPullStyleSimulation.simulate();
        MediatorSimulation.simulate();
        ChainOfResponsibilitySimulation.simulate();
        SimulateVisitor.simulate();
        SimulateComposite.simulate();
        AdapterSimulator.simulate();
*/
    }
}