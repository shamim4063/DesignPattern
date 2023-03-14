package io.hmshamim.mediator;

public class ArticleDialogBox extends DialogBox{
    public ListBox articleListBox=new ListBox(this);
    public Button saveButton=new Button(this);
    public TextBox titleTextBox=new TextBox(this);
    @Override
    public void changed(UIControl control) {
        if(control == articleListBox)
            articleSelected();
        if(control == titleTextBox)
            titleChanged();
    }

    private void articleSelected(){
        titleTextBox.setContent(articleListBox.getSelection());
        saveButton.setEnabled(true);
    }

    private void titleChanged(){
        var content = titleTextBox.getContent();
        var isEmpty = content== null || content.isEmpty();
        saveButton.setEnabled(!isEmpty);
    }
}
