package iss.medipal.asyncs;

import android.content.Context;
import android.os.AsyncTask;

import iss.medipal.dao.impl.PersonBioDaoImpl;
import iss.medipal.model.PersonalBio;
import iss.medipal.ui.interfaces.OnTaskCompleted;

/**
 * Created by junaidramis on 17/3/17.
 */

public class EditPersonalBioTask extends AsyncTask<PersonalBio, Void, Long> {
    private PersonBioDaoImpl mBioDao;

    public EditPersonalBioTask(Context context) {
        this.mBioDao = new PersonBioDaoImpl(context);
    }

    @Override
    protected Long doInBackground(PersonalBio... params) {
        long result = mBioDao.updatePersonalBio(params[0]);
        return result;
    }

    @Override
    protected void onPostExecute(Long result) {
        if (result != -1)
            if (mBioDao != null)
                mBioDao.close();
    }
}