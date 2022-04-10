/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import java.util.List;

/**
 *
 * @author Ngọc Hùng
 */
public interface IService<T> {

    public List<T> getlst();

    public void getSelectData();

    public String getEditData(T t, String style);
    
    public List<T> find(String ma);
    
    public List<T> sort(String style);
}
