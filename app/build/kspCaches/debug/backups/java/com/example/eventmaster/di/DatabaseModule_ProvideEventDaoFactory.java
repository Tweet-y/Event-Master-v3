package com.example.eventmaster.di;

import com.example.eventmaster.data.local.dao.EventDao;
import com.example.eventmaster.data.local.database.EventMasterDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.Providers;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class DatabaseModule_ProvideEventDaoFactory implements Factory<EventDao> {
  private final Provider<EventMasterDatabase> databaseProvider;

  public DatabaseModule_ProvideEventDaoFactory(Provider<EventMasterDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public EventDao get() {
    return provideEventDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideEventDaoFactory create(
      javax.inject.Provider<EventMasterDatabase> databaseProvider) {
    return new DatabaseModule_ProvideEventDaoFactory(Providers.asDaggerProvider(databaseProvider));
  }

  public static DatabaseModule_ProvideEventDaoFactory create(
      Provider<EventMasterDatabase> databaseProvider) {
    return new DatabaseModule_ProvideEventDaoFactory(databaseProvider);
  }

  public static EventDao provideEventDao(EventMasterDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideEventDao(database));
  }
}
