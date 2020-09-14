package com.spring.mvc.ex02.component;

public class AccessPerm {

	private String id;
	private boolean canRead;
	private boolean canCreate;
	private boolean canModify;
	private boolean canDelete;
	private boolean removed;

	public String getId() {
		System.out.println("AccessPerm public String getId");
		return id;
	}

	public void setId(String id) {
		System.out.println("AccessPerm setter");
		this.id = id;
	}

	public boolean isCanRead() {
		return canRead;
	}

	public void setCanRead(boolean canRead) {
		this.canRead = canRead;
	}

	public boolean isCanCreate() {
		return canCreate;
	}

	public void setCanCreate(boolean canCreate) {
		this.canCreate = canCreate;
	}

	public boolean isCanModify() {
		return canModify;
	}

	public void setCanModify(boolean canModify) {
		this.canModify = canModify;
	}

	public boolean isCanDelete() {
		return canDelete;
	}

	public void setCanDelete(boolean canDelete) {
		this.canDelete = canDelete;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void setRemoved(boolean removed) {
		this.removed = removed;
	}

	public void copyFrom(AccessPerm other) {
		this.canRead = other.canRead;
		this.canCreate = other.canCreate;
		this.canModify = other.canModify;
		this.canDelete = other.canDelete;
		this.removed = other.removed;
	}

	@Override
	public String toString() {
		return "AccessPerm [id=" + id + ", canRead=" + canRead + ", canCreate=" + canCreate + ", canModify=" + canModify + ", canDelete=" + canDelete
				+ ", removed=" + removed + "]";
	}

	public boolean hasData() {
		return id != null;
	}

}
