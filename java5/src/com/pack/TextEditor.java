package com.pack;

public class TextEditor {
private String name;
private SpellChecker spell;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public SpellChecker getSpell() {
	return spell;
}
public void setSpell(SpellChecker spell) {
	this.spell = spell;
}
public void show()
{
	spell.checkSpelling();
}
public TextEditor(String name, SpellChecker spell) {
	super();
	this.name = name;
	this.spell = spell;
}
public TextEditor() {
	super();
}

}
