package com.pack;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
	/*@Autowired*/
private SpellChecker spell;

/*public SpellChecker getSpell() {
	return spell;
}
@Autowired
public void setSpell(SpellChecker spell) {
	this.spell = spell;
}*/
	
public void test(){
	spell.checkSpelling();
}
@Autowired
public TextEditor(SpellChecker spell) {
	super();
	this.spell = spell;
	System.out.println("inside text editor constructor");
}
}
