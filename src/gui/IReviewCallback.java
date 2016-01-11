package gui;

import data.Mitglied;

/**
 * Created by xor on 1/11/16.
 */
public interface IReviewCallback {
    void onReviewOk(Mitglied mitglied);
    void onReviewCancel();
}
