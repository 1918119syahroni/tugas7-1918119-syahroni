package com.example.tugas7_1918119;

public class Design {
    private String _id, _logo, _tagline;
    public Design(String id, String logo, String tagline) {
        this._id = id;
        this._logo = logo;
        this._tagline = tagline;
    }
    public Design() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_logo() {
        return _logo;
    }
    public void set_logo(String _logo) { this._logo = _logo;
    }
    public String get_tagline() {
        return _tagline;
    }
    public void set_tagline(String _tagline) {
        this._tagline = _tagline;
    }
}

