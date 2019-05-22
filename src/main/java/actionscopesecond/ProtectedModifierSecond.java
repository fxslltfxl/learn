package actionscopesecond;

import actionscopefirst.ProtectedModifierFirst;

public class ProtectedModifierSecond {
    protected void protectedMethod(){
        ProtectedModifierFirst protectedModifierFirst = new ProtectedModifierFirst();

        // can't
//        protectedModifierFirst.protectedMethod();
    }
}
