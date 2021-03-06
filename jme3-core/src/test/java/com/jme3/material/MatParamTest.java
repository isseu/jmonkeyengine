package com.jme3.material;

import org.junit.Test;

import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.math.Vector4f;
import com.jme3.shader.VarType;

/**
 * @author Enrique Correa
 */
public class MatParamTest {
    @Test
    public void testGetValueAsString() {
        MatParam mat_param = new MatParam(VarType.Float, "test1", 0.505f);
        assert mat_param.getValueAsString().equals("0.505");
        mat_param = new MatParam(VarType.Vector2, "test2", new Vector2f(5f, 4f));
        assert mat_param.getValueAsString().equals("5.0 4.0");
        mat_param = new MatParam(VarType.Vector3, "test3", new Vector3f(5f, 4f, 1f));
        assert mat_param.getValueAsString().equals("5.0 4.0 1.0");
        mat_param = new MatParam(VarType.Vector4, "test4", new Vector4f(5f, 4f, 1f, -10f));
        assert mat_param.getValueAsString().equals("5.0 4.0 1.0 -10.0");
        mat_param = new MatParam(VarType.IntArray, "test4", 1);
        assert mat_param.getValueAsString() == null;
        mat_param = new MatParam(VarType.Vector4Array, "test5", 1);
        assert mat_param.getValueAsString() == null;
        mat_param = new MatParam(VarType.Boolean, "test6", true);
        assert mat_param.getValueAsString().equals("true");
    }

    @Test
    public void testEquals() {
        // Same everything
        MatParam mat_param1 = new MatParam(VarType.Float, "test1", 0.505f);
        MatParam mat_param2 = new MatParam(VarType.Float, "test1", 0.505f);
        assert mat_param1.equals(mat_param2);
        // Diff Value
        mat_param2.setValue(0.5f);
        assert !mat_param1.equals(mat_param2);
        // Diff Name
        mat_param1 = new MatParam(VarType.Vector2, "test2", new Vector2f(5f, 4f));
        mat_param2 = new MatParam(VarType.Vector2, "test3", new Vector2f(5f, 4f));
        assert !mat_param1.equals(mat_param2);
        // Diff VarType
        mat_param1 = new MatParam(VarType.IntArray, "test4", 1);
        mat_param2 = new MatParam(VarType.Vector4Array, "test4", 1);
        assert !mat_param1.equals(mat_param2);
    }
}
