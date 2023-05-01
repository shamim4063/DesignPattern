package io.hmshamim;


import io.hmshamim.decorator.DecoratorSimulation;

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
        DecoratorSimulation.simulate();
    }
}