package com.andevcba.materializeme.presentation.main.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Pattern implements Parcelable {

    public String id;
    public String name;
    public String shortDescription;
    public String description;

    public static final List<Pattern> ITEMS = new ArrayList<>();

    public Pattern(String id, String name, String shortDescription, String description) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.description = description;
    }

    static {
        ITEMS.add(0,
                new Pattern(String.valueOf(0),
                        "Navigation Drawer",
                        "The navigation drawer slides in from the left and contains the navigation destinations for your app.",
                        "When there is insufficient space to support tabs, side navigation is " +
                "a good alternative. Side navigation can display many navigation targets at once. A drawer remains hidden until invoked by the user" +
                ".\n" +
                "\n" +
                "Apps with a single “home” should list the most frequently accessed destinations at the top of side navigation.\n" +
                "\n" +
                "Side navigation may appear either with or without a navigation drawer.\n" +
                "\n" +
                "Appropriate for these hierarchies:\n" +
                "\n" +
                "Lateral navigation\n" +
                "Parents with siblings or peers\n" +
                "Recommended for:\n" +
                "\n" +
                "Apps with many top-level views\n" +
                "Enabling quick navigation between unrelated views\n" +
                "Deep navigation structures\n" +
                "Reducing visibility of infrequent destinations"));

        ITEMS.add(1,
                new Pattern(String.valueOf(1),
                        "Nested Navigation",
                        "Used with multiple levels of navigation",
                        "When you have multiple levels of navigation, sibling views should be nested underneath their parent.\n" +
                "On desktop, a secondary level of navigation may be nested within the navigation drawer.\n" +
                "\n" +
                "Appropriate for these hierarchies:\n" +
                "\n" +
                "Lateral navigation\n" +
                "Parents with siblings or peers\n" +
                "Recommended for:\n" +
                "\n" +
                "Deep navigation structures with many views\n" +
                "Enabling quick navigation between unrelated views"));

        ITEMS.add(2,
                new Pattern(String.valueOf(2),
                        "Expanding navigation drawer",
                        "Perfect for deep navigational hierarchy",
                        "If you have a deep navigational hierarchy, you may use cascading menus to expand navigation drawer content horizontally. Each " +
                        "collection of views is presented in its own panel, and a " +
                "level closes when a subsection is selected."));

        ITEMS.add(3,
                new Pattern(String.valueOf(3),
                        "Bottom Navigation",
                        "Suites great for a small number of top-level views",
                        "A bottom navigation bar allows users to quickly move between a small number of top-level views.\n" +
                "Appropriate for these hierarchies:\n" +
                "\n" +
                "Parents with embedded child views\n" +
                "A group of parent views\n" +
                "Recommended for:\n" +
                "\n" +
                "Frequent switching between views\n" +
                "Apps with few top-level views\n" +
                "Promoting awareness of alternate views\n" +
                "Mobile devices, as bottom navigation is located in a more ergonomic location"));

        ITEMS.add(4,
                new Pattern(String.valueOf(4),
                        "Tabs Navigation",
                        "Mostly used on small number of important views",
                        "Tabs allow users to quickly move between a small number of equally important views.\n" +
                "Appropriate for these hierarchies:\n" +
                "\n" +
                "Parents with embedded child views\n" +
                "A group of sibling views\n" +
                "Recommended for:\n" +
                "\n" +
                "Frequent switching between views\n" +
                "Apps with few top-level views\n" +
                "Promoting awareness of alternate views"));

        ITEMS.add(5,
                new Pattern(String.valueOf(5),
                        "Embedded Navigation",
                        "Just one view apps",
                        "Apps with simple navigation may embed navigation inside app content, but doing so reduces the available space to display " +
                                "that content.\n" +
                "Recommended for:\n" +
                "\n" +
                "Apps with a strong primary view, and few alternate views\n" +
                "Apps that perform common tasks in the main view\n" +
                "Infrequently used apps"));

        ITEMS.add(6,
                new Pattern(String.valueOf(6),
                        "Gestural Navigation",
                        "Used to change views with gestures",
                        "Gestural navigation allows users to use swipe gestures to navigate between sibling or peer views. Supported gestures " +
                                "include:  touching and dragging the screen horizontally (left/right), vertically (up/down), or while zooming in or" +
                                " out.\n" +
                "Recommended for:\n" +
                "\n" +
                "Naturally ordered relationships, such as pages representing consecutive calendar days\n" +
                "Views with few siblings\n" +
                "Views with similar content types\n" +
                "See Navigational transitions for more information on hierarchical journeys between scenes."));

        ITEMS.add(7,
                new Pattern(String.valueOf(7),
                        "In-context navigation",
                        "Used for deep navigation",
                        "In-context navigation (used with tabs or navigation drawers) allows nimble movement between related sets of data.\n" +
                        "In-context navigation integrates into an app’s content and is typically less linear in nature. When moving through in-context " +
                "navigation, navigating to a new scene will display navigational controls specific to that view.\n" +
                "\n" +
                "Appropriate for these hierarchies:\n" +
                "\n" +
                "Parents with siblings\n" +
                "Recommended for:\n" +
                "\n" +
                "Showing large sets of child scenes\n" +
                "Focusing attention on a specific set of tasks\n" +
                "Apps with a strong primary view, and few alternates\n" +
                "Example uses:\n" +
                "\n" +
                "Link a song to an artist\n" +

                "Move between recent items and a complete history\n" +
                "Connect a user’s post to their profile page\n" +
                "The up arrow is used to return to the previous level."));

        ITEMS.add(8,
                new Pattern(String.valueOf(8),
                        "Side nav and tab combinations",
                        "Navigation Drawer + Tabs",
                        "Products with two levels of navigation may pair a left navigation drawer with tabs."));
    }

    @Override
    public String toString() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.shortDescription);
        dest.writeString(this.description);
    }

    protected Pattern(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.shortDescription = in.readString();
        this.description = in.readString();
    }

    public static final Creator<Pattern> CREATOR = new Creator<Pattern>() {
        @Override
        public Pattern createFromParcel(Parcel source) {
            return new Pattern(source);
        }

        @Override
        public Pattern[] newArray(int size) {
            return new Pattern[size];
        }
    };
}
