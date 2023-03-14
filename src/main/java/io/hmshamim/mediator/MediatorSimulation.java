package io.hmshamim.mediator;

public class MediatorSimulation {
    public static void  simulate(){
        var articleDialogBox = new ArticleDialogBox();
        articleDialogBox.articleListBox.setSelection("Article 1");
        System.out.println("Currently selected article: " + articleDialogBox.titleTextBox.getContent());
        System.out.println("Save buttons enable status: " + articleDialogBox.saveButton.isEnabled());

        articleDialogBox.titleTextBox.setContent("");
        System.out.println("Currently selected article: " + articleDialogBox.titleTextBox.getContent());
        System.out.println("Save buttons enable status: " + articleDialogBox.saveButton.isEnabled());

        articleDialogBox.titleTextBox.setContent("Updated Article");
        System.out.println("Currently selected article: " + articleDialogBox.titleTextBox.getContent());
        System.out.println("Save buttons enable status: " + articleDialogBox.saveButton.isEnabled());

        articleDialogBox.articleListBox.setSelection("Article 2");
        System.out.println("Currently selected article: " + articleDialogBox.titleTextBox.getContent());
        System.out.println("Save buttons enable status: " + articleDialogBox.saveButton.isEnabled());
    }
}
