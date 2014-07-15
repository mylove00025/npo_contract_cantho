package com.osp.npo.core.contract;

import java.util.ArrayList;
import java.util.List;

public class ContractKindTreeNode {
    public static final String NODE_CONSTANT = "node";
    public static final String DIV_OPEN_CONSTANT = "div_open";
    public static final String DIV_CLOSE_CONSTANT = "div_close";
    public enum DivStyle {
        /** Node */
        NODE
        /** Div open */
        , DIV_OPEN
        /** Div close */
        , DIV_CLOSE

        ;


        public String getValue() {
            switch (this) {
            case NODE:
                return NODE_CONSTANT;
            case DIV_OPEN:
                return DIV_OPEN_CONSTANT;
            case DIV_CLOSE:
                return DIV_CLOSE_CONSTANT;
            default:
                return null;
            }
        }


        public static DivStyle changeValue(String value) {
            if (value == null) {
                return null;
            }
            if (NODE_CONSTANT.equals(value)) {
                return NODE;
            } else if (DIV_OPEN_CONSTANT.equals(value)) {
                return DIV_OPEN;
            } else if (DIV_CLOSE_CONSTANT.equals(value)) {
                return DIV_CLOSE;
            } else {
                return null;
            }
        }
    };
    private String divStyle;
    private Long id;
    private String name;
    private Long parentId;
    private List<ContractKindTreeNode> children;
    private int level;
    /**
     * @return the divStyle
     */
    public String getDivStyle() {
        return divStyle;
    }
    /**
     * @param divStyle the divStyle to set
     */
    public void setDivStyle(String divStyle) {
        this.divStyle = divStyle;
    }
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get parentId
     * @return the parentId
     */
    public Long getParentId() {
        return parentId;
    }
    /**
     * Set parentId
     * @param parentId the parentId to set
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * @return the children
     */
    public List<ContractKindTreeNode> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<ContractKindTreeNode> children) {
        this.children = children;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     *
     * Add child node
     *
     * @author GiangVT
     * @param node child
     */
    public void addChild(ContractKindTreeNode node) {
        if (children == null) {
            children = new ArrayList<ContractKindTreeNode>();
            children.add(node);
        } else if (children.isEmpty()){
            children.add(node);
        } else {
            boolean isInserted = false;
            for (int i = 0; i < children.size(); i++) {
                ContractKindTreeNode tmpNode = children.get(i);
                if (node.getName().compareToIgnoreCase(tmpNode.getName()) < 0) {
                    children.add(i, node);
                    isInserted = true;
                    break;
                }
            }

            if (!isInserted) {
                children.add(node);
            }
        }
    }

    /**
     * Parse children to list
     * @return list child
     */
    public List<ContractKindTreeNode> parseChildrenList() {
        List<ContractKindTreeNode> list = new ArrayList<ContractKindTreeNode>();
        if (this.children != null && !this.children.isEmpty()) {
            for (ContractKindTreeNode child : this.children) {
                list.add(child);
                list.addAll(child.parseChildrenList());
            }
        }
        return list;
    }
    
    /**
     * Get space
     *
     * @param num number of space
     * @return
     */
    public String getSpaces() {
        String spaces = "";
        for (int i = 0; i < level * 4; i++) {
            spaces += "&nbsp;";
        }
        return spaces;
    }
}
