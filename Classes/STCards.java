/**
 * Created by Ashlee Ryland on 12/09/2016.
 */
public class STCards
{
    public String categoryNames(int keyCategory) {
        int categoryNum = keyCategory;
        String categoryName = null;
        switch (categoryNum) {
            case 6:
                categoryName = "Hardeness";
                break;
            case 7:
                categoryName = "Specific gravity";
                break;
            case 8:
                categoryName = "Cleavage";
                break;
            case 9:
                categoryName = "Crustal abundance";
                break;
            case 10:
                categoryName = "Economic Value";
                break;
        }
        return categoryName;
    }



}
