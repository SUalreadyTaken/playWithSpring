in createQuery use **java property name** not database column name

by default no operations are cascaded  

if u dont want to use cascade=CascadeType.ALL u can specify which type u want to use like this .. cascade={CascadeType.DETACH, CascadeType.MERGE ...}

for bi-directional @OneToOne(mappedBy=""child_variable_name_in_parent_class") hibernate will look for child property in parent class and use the information @JoinColumn in parent class  

in lazy_fetch if u use courses(child) in teacher(parent) toString it will act as ?? EAGER fetch even if u give it a LAZY fetch type why not just display null ??  


![oneToOne](images/oneToOne.png)

