package es.npatarino.android.gotchallenge.di.components;

import javax.inject.Named;

import dagger.Component;
import es.npatarino.android.gotchallenge.data.source.remote.JsonMapper;
import es.npatarino.android.gotchallenge.di.Activity;
import es.npatarino.android.gotchallenge.di.AppComponent;
import es.npatarino.android.gotchallenge.di.modules.ActivityModule;
import es.npatarino.android.gotchallenge.di.modules.CharactersModule;
import es.npatarino.android.gotchallenge.domain.GoTCharacter;
import es.npatarino.android.gotchallenge.domain.datasource.local.CharacterLocalDataSource;
import es.npatarino.android.gotchallenge.domain.datasource.remote.CharacterRemoteDataSource;
import es.npatarino.android.gotchallenge.domain.interactor.GetCharactersByHouseUseCase;
import es.npatarino.android.gotchallenge.domain.interactor.common.GetListUseCase;
import es.npatarino.android.gotchallenge.domain.repository.GotCharacterRepository;
import es.npatarino.android.gotchallenge.presenter.CharacterListPresenter;
import es.npatarino.android.gotchallenge.presenter.GotCharacterListByHousePresenter;
import es.npatarino.android.gotchallenge.view.fragment.GoTListFragment;
import es.npatarino.android.gotchallenge.view.fragment.GotCharacterListByHouseFragment;

/**
 * @author Antonio López.
 */
@Activity
@Component(dependencies = AppComponent.class, modules = {CharactersModule.class, ActivityModule.class})
public interface CharactersComponent extends ActivityComponent{

    void inject(GotCharacterListByHouseFragment fragment);
    void inject(GoTListFragment fragment);

    JsonMapper gotCharacterJsonMapper();

    //datasource
    CharacterRemoteDataSource characterRemoteDataSource();
    CharacterLocalDataSource characterLocalDataSource();

    //repository
    GotCharacterRepository gotCharacterRepository();

    //UseCase
    GetCharactersByHouseUseCase charactersByHouseUseCase();
    @Named("character") GetListUseCase<GoTCharacter> gotCharacterListUseCase();

    //Presenter
    CharacterListPresenter gotCharacterListPresenter();
    GotCharacterListByHousePresenter gotCharacterListByHousePresenter();
}
